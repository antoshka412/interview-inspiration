package org.problem.concurrency.leetcode.printorder.impl;

import org.problem.concurrency.leetcode.printorder.PrintOrder;

public class PrintOrderWithWaitAndNotify implements PrintOrder {

    private volatile boolean isFirstDone = false;
    private volatile boolean isSecondDone = false;

    public PrintOrderWithWaitAndNotify() {
    }

    synchronized public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        isFirstDone = true;
        notifyAll();
    }

    synchronized public void second(Runnable printSecond) throws InterruptedException {
        while (!isFirstDone) {
            wait();
        }
        printSecond.run();
        isSecondDone = true;
        notifyAll();
    }

    synchronized public void third(Runnable printThird) throws InterruptedException {
        while (!isSecondDone) {
            wait();
        }
        printThird.run();
    }

}
