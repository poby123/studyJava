package threads;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class ReentrantLocks {

    private static Account account = new Account();
    private static Lock key = new ReentrantLock();

    private static Consumer<Integer> deposit = (Integer val) -> account.deposit(new BigDecimal(val));
    private static Consumer<Integer> withdraw = (Integer val) -> account.withdraw(new BigDecimal(val));

    private static BiFunction<Consumer<Integer>, Integer, Runnable> outsideLock = (Consumer<Integer> f, Integer sleepTime) -> {
        return new Runnable() {
            public void run() {
                key.lock();
                try {
                    for (int i = 0; i < 5; i++) {
                        f.accept(100);
                        Thread.sleep(sleepTime);
                    }
                } catch (InterruptedException ie) {
    
                } finally {
                    key.unlock();
                }
            }
        };
    };

    private static BiFunction<Consumer<Integer>, Integer, Runnable> insideLock = (Consumer<Integer> f, Integer sleepTime) -> {
        return new Runnable() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    key.lock();
                    try {
                        account.deposit(new BigDecimal(100));
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException ie) {
    
                    } finally {
                        key.unlock();
                    }
                }
            }
        };
    };

    static BiConsumer<Runnable, Runnable> reentrantExample = (Runnable depositRunnable, Runnable withdrawRunnable) -> {
        Thread depositThread1 = new Thread(depositRunnable, "deposit1");
        Thread depositThread2 = new Thread(depositRunnable, "deposit2");
        Thread withdrawThread1 = new Thread(withdrawRunnable, "withdraw1");
        Thread withdrawThread2 = new Thread(withdrawRunnable, "withdraw2");

        depositThread1.start();
        depositThread2.start();
        withdrawThread1.start();
        withdrawThread2.start();

        try {
            depositThread1.join();
            depositThread2.join();
            withdrawThread1.join();
            withdrawThread2.join();
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
    };

    public static double measureTime(BiConsumer<Runnable, Runnable> f, Runnable r1, Runnable r2){
        long sum = 0L;
        final int N = 10;

        for (int i = 0; i < N; i++) {
            long start = System.currentTimeMillis();
            f.accept(r1, r2);
            long end = System.currentTimeMillis();
            sum += (end - start);
        }
        return (double) sum / N;
    }

    public static void main(String... args) {
        Runnable r1 = outsideLock.apply(deposit, 0);
        Runnable r2 = outsideLock.apply(withdraw, 0);

        // 현재의 inside lock은 기아가 생긴다. 조건변수를 이용해 해결해보자.
        Runnable r3 = insideLock.apply(deposit, 0);
        Runnable r4 = insideLock.apply(withdraw, 0);
    
        double avgOutLock = measureTime(reentrantExample, r1, r2);
        // double avgInLock = measureTime(reentrantExample, r3, r4);

        System.out.println("Lock at outside of loop, Avg Running time : " + avgOutLock + " ms");
        // System.out.println("Lock at inside of loop, Avg Running time : " + avgInLock + " ms");
    }
}
