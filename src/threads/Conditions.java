package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Conditions {

    private static final Lock lock = new ReentrantLock();
    private static Condition[] condVars = new Condition[5];
    private static List<Thread> threads = new ArrayList<>();
    private static int turn = 3;

    public static void doWork(int threadNumber) {
        lock.lock();
        try {
            if (threadNumber != turn) {
                System.out.println("wait turn... " + threadNumber);
                condVars[threadNumber].await();
            }

            System.out.println("Wakeup! Do work " + threadNumber);
            Thread.sleep(1000);

            turn = (turn + 1) % 5;

            System.out.println("signal to " + turn);
            condVars[turn].signal();
        } catch (InterruptedException ie) {
            System.out.println(ie);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String... args) {
        for (int i = 0; i < 5; i++) {
            final int threadNumber = i;
            condVars[i] = lock.newCondition();
            threads.add(new Thread(() -> doWork(threadNumber)));
        }

        for (Thread t : threads) {
            t.start();
        }

        try {
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException ie) {
        }
    }
}
