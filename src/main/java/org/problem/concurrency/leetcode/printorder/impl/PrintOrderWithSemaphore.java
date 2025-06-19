package org.problem.concurrency.leetcode.printorder.impl;

import java.util.concurrent.Semaphore;
import org.problem.concurrency.leetcode.printorder.PrintOrder;

public class PrintOrderWithSemaphore implements PrintOrder {

    private final Semaphore firstMethodDone = new Semaphore(0);
    private final Semaphore secondMethodDone = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        firstMethodDone.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        firstMethodDone.acquire();
        printSecond.run();
        secondMethodDone.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        secondMethodDone.acquire();
        printThird.run();
    }

}
