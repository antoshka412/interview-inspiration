package org.problem.concurrency.leetcode.printorder;

public interface PrintOrder {

    void first(Runnable printFirst) throws InterruptedException;

    void second(Runnable printSecond) throws InterruptedException;

    void third(Runnable printThird) throws InterruptedException;

}
