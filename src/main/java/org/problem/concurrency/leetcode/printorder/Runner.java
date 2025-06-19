package org.problem.concurrency.leetcode.printorder;

import org.problem.concurrency.leetcode.printorder.impl.PrintOrderWithSemaphore;

public class Runner {

    // Test setup
    public static void main(String[] args) {
        PrintOrder printOrder = new PrintOrderWithSemaphore();

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
