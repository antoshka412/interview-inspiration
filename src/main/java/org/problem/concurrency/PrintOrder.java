package org.problem.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Leetcode problem: https://leetcode.com/problems/print-in-order/description/
 */
public class PrintOrder {

    private final Lock lock = new ReentrantLock();
    private final Condition firstCalled = lock.newCondition();
    private final Condition secondCalled = lock.newCondition();

    private boolean isFirstDone = false;
    private boolean isSecondDone = false;

    public PrintOrder() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            printFirst.run();
            isFirstDone = true;
            firstCalled.signal();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (!isFirstDone) {
                firstCalled.await();
            }
            printSecond.run();
            isSecondDone = true;
            secondCalled.signal();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (!isSecondDone) {
                secondCalled.await();
            }
            printThird.run();
        } finally {
            lock.unlock();
        }
    }

    // Test setup
    public static void main(String[] args) {
        PrintOrder printOrder = new PrintOrder();

        Runnable printFirst = () -> System.out.print("first");
        Runnable printSecond = () -> System.out.print("second");
        Runnable printThird = () -> System.out.print("third");

        Thread t1 = new Thread(() -> {
            try {
                printOrder.first(printFirst);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                printOrder.second(printSecond);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                printOrder.third(printThird);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Randomize the order of starting threads
        Thread[] threads = { t1, t2, t3 };
        java.util.Collections.shuffle(java.util.Arrays.asList(threads));
        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
