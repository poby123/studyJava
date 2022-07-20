// https://velog.io/@codemcd/%EC%9A%B4%EC%98%81%EC%B2%B4%EC%A0%9COS-9.-%ED%94%84%EB%A1%9C%EC%84%B8%EC%8A%A4-%EB%8F%99%EA%B8%B0%ED%99%94-2

package threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class BoundedBuffer<E> {

    private final int n = 10;
    private Queue<E> buffer = new LinkedList<>();
    private Semaphore mutex = new Semaphore(1);
    private Semaphore empty = new Semaphore(n);
    private Semaphore full = new Semaphore(0);

    public void produce(E item) {
        try {
            empty.acquire();
            mutex.acquire();

            buffer.add(item);
            if (buffer.size() > n) {
                throw new IllegalStateException("size " + buffer.size() + " is bigger than " + n);
            }
            System.out.println("Add " + item + ", size : " + buffer.size());

            mutex.release();
            full.release();
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
    }

    public void consume() {
        try {
            full.acquire();
            mutex.acquire();

            E item = buffer.poll();
            if (item != null) {
                System.out.println("Polled item : " + item + " size : " + buffer.size());
            } else {
                System.out.println("Polled Null");
                throw new NullPointerException("Polled item is null");
            }

            mutex.release();
            empty.release();

        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
    }

    public static void main(String... args) {
        BoundedBuffer<Integer> buffer = new BoundedBuffer<>();

        Thread produce = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                buffer.produce(i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ie) {
                    System.out.println(ie);
                }
            }
        });

        Thread consume = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                buffer.consume();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ie) {
                    System.out.println(ie);
                }
            }
        });

        produce.start();
        consume.start();

        try {
            produce.join();
            consume.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
