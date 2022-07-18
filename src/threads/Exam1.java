package threads;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class PrintX implements Runnable {

    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
                System.out.println("x");
            } catch (InterruptedException ie) {
                System.out.println(Thread.currentThread().getName() + " is interrupted!");
                return;
            }
        }
    }
}

class SumArrays implements Runnable {
    List<Integer> target = new ArrayList<>();
    AtomicInteger acc;

    SumArrays(List<Integer> target, AtomicInteger acc) {
        this.acc = acc;

        if (target != null) {
            this.target = target;
        } else {
            throw new NullPointerException();
        }
    }

    public void run() {
        try {
            for (Integer i : target) {
                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName() + " : " + i);
                acc.addAndGet(i);
            }
        } catch (InterruptedException ie) {

        }
    }
}

class Account {
    private BigDecimal balance;

    public Account() {
        this(0);
    }

    public Account(int b) {
        this.balance = new BigDecimal(b);
    }

    public synchronized BigDecimal withdraw(BigDecimal target) {
        if (balance.compareTo(target) > 0) {
            balance = balance.subtract(target);
            System.out.println("After withdraw " + target + " \t/\t balance : " + balance);
            return target;
        }
        return new BigDecimal(0);
    }

    public synchronized boolean deposit(BigDecimal input) {
        if (input.compareTo(new BigDecimal(0)) >= 0) {
            balance = balance.add(input);
            System.out.println("After deposit " + input + " \t/\t balance : " + balance);
            return true;
        }
        return false;
    }
}

public class Exam1 {

    public static void runE1() {
        Thread t1 = new Thread(new PrintX(), "printX");
        t1.start();

        try {
            Thread.sleep(5000);
            t1.interrupt();
            t1.join();
        } catch (InterruptedException ie) {
            System.out.println(Thread.currentThread().getName() + " is interrupted!");
        }

        System.out.println("main process is ended");
    }

    public static void runE2() {
        AtomicInteger acc = new AtomicInteger(0);
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Thread t1 = new Thread(new SumArrays(list.subList(0, 5), acc), "0~4 sum");
        Thread t2 = new Thread(new SumArrays(list.subList(5, 10), acc), "5~9 sum");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            System.out.println("result : " + acc);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }

    }

    public static void runE3() {
        Account account = new Account(0);

        Runnable depositRunnable = new Runnable() {
            public void run() {
                // synchronized (this) {
                    for (int i = 0; i < 5; i++) {
                        try {
                            Thread.sleep(1);
                            account.deposit(new BigDecimal(100));
                            System.out.println("Deposit in " + Thread.currentThread().getName());
                        } catch (InterruptedException ie) {

                        }
                    }
                // }
            }
        };

        Runnable withDrawRunnable = new Runnable() {
            public void run() {
                // synchronized (this) {
                    for (int i = 0; i < 5; i++) {
                        try {
                            Thread.sleep(1);
                            account.withdraw(new BigDecimal(200));
                            System.out.println("Withdraw in " + Thread.currentThread().getName());
                        } catch (InterruptedException ie) {

                        }
                    }
                // }
            }
        };

        Thread deposit = new Thread(depositRunnable, "deposit1");
        Thread deposit2 = new Thread(depositRunnable, "deposit2");
        Thread withdraw = new Thread(withDrawRunnable, "withdraw1");
        Thread withdraw2 = new Thread(withDrawRunnable, "withdraw2");

        deposit.start();
        deposit2.start();
        withdraw.start();
        withdraw2.start();

        try {
            deposit.join();
            deposit2.join();
            withdraw.join();
            withdraw2.join();
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
    }

    public static void main(String[] args) {
        // runE1();
        // runE2();
        long startTime = System.currentTimeMillis();
        runE3();
        long endTime = System.currentTimeMillis();

        System.out.println("Running time : " + (endTime - startTime));
    }
}

/*
 * Before sync runE3
 * After deposit 100 / balance : 200 !
 * After deposit 100 / balance : 200
 * After deposit 100 / balance : 300
 * After deposit 100 / balance : 400
 * After withdraw 200 / balance : 200
 * After deposit 100 / balance : 300
 * After deposit 100 / balance : 400
 * After withdraw 200 / balance : 200
 * After withdraw 200 / balance : 200 !
 * After deposit 100 / balance : 300
 * After deposit 100 / balance : 400
 * After withdraw 200 / balance : 200
 * After deposit 100 / balance : 300
 * After deposit 100 / balance : 400
 * 
 * 
 * 
 * After sync runE3
 * After deposit 100 / balance : 100
 * After deposit 100 / balance : 200
 * After deposit 100 / balance : 300
 * After withdraw 200 / balance : 100
 * After deposit 100 / balance : 200
 * After deposit 100 / balance : 300
 * After withdraw 200 / balance : 100
 * After deposit 100 / balance : 200
 * After deposit 100 / balance : 300
 * After withdraw 200 / balance : 100
 * After deposit 100 / balance : 200
 * After deposit 100 / balance : 300
 * After withdraw 200 / balance : 100
 * After deposit 100 / balance : 200
 */

/**
 * Method Synchronized : 1과 2가 번갈아가면서 실행됨. 약 15ms의 실행시간
 * After deposit 100 / balance : 100
 * Deposit in deposit1
 * Withdraw in withdraw2
 * After deposit 100 / balance : 200
 * Deposit in deposit2
 * Withdraw in withdraw1
 * Withdraw in withdraw2
 * After deposit 100 / balance : 300
 * Deposit in deposit1
 * After deposit 100 / balance : 400
 * Deposit in deposit2
 * After withdraw 200 / balance : 200
 * Withdraw in withdraw1
 * Withdraw in withdraw2
 * After deposit 100 / balance : 300
 * Deposit in deposit1
 * After deposit 100 / balance : 400
 * Deposit in deposit2
 * After withdraw 200 / balance : 200
 * Withdraw in withdraw1
 * Withdraw in withdraw2
 * After deposit 100 / balance : 300
 * Deposit in deposit1
 * After withdraw 200 / balance : 100
 * Withdraw in withdraw1
 * After deposit 100 / balance : 200
 * Deposit in deposit2
 * Withdraw in withdraw2
 * After deposit 100 / balance : 300
 * Deposit in deposit1
 * After withdraw 200 / balance : 100
 * Withdraw in withdraw1
 * After deposit 100 / balance : 200
 * 
 * 
 * Synchronized in run mehtod : 1이 실행되고, 2가 실행됨. 약 20ms 실행시간
 * 
 * Withdraw in withdraw1
 * After deposit 100 / balance : 100
 * Deposit in deposit1
 * Withdraw in withdraw1
 * After deposit 100 / balance : 200
 * Deposit in deposit1
 * Withdraw in withdraw1
 * After deposit 100 / balance : 300
 * Deposit in deposit1
 * After withdraw 200 / balance : 100
 * Withdraw in withdraw1
 * After deposit 100 / balance : 200
 * Deposit in deposit1
 * Withdraw in withdraw1
 * After deposit 100 / balance : 300
 * Deposit in deposit1
 * After withdraw 200 / balance : 100
 * Withdraw in withdraw2
 * After deposit 100 / balance : 200
 * Deposit in deposit2
 * Withdraw in withdraw2
 * After deposit 100 / balance : 300
 * Deposit in deposit2
 * After withdraw 200 / balance : 100
 * Withdraw in withdraw2
 * After deposit 100 / balance : 200
 * Deposit in deposit2
 * Withdraw in withdraw2
 * After deposit 100 / balance : 300
 * Deposit in deposit2
 * After withdraw 200 / balance : 100
 * Withdraw in withdraw2
 * After deposit 100 / balance : 200
 * Deposit in deposit2
 */