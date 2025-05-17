package org.problem.datastructure;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Task: To implement own stack of ints using java collection.
 * Stack should include add, pop, peek methods.
 * This stack should support constant time retrieval of the minimum element.
 */
public class MyStack {
    private final Deque<Integer> list = new LinkedList<>();

    // To support constant time retrieval of the minimum element in a stack, I will use an auxiliary stack
    private final Deque<Integer> minStack = new LinkedList<>();

    // Add the value at the top of the stack
    public void add(Integer value) {
        list.push(value);
        if (minStack.isEmpty() || value <= minStack.peekFirst()) {
            minStack.push(value);
        }
    }

    // Pop the top value from the stack
    public int pop() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int value = list.pop();
        if (value == minStack.peekFirst()) {
            minStack.pop();
        }
        return value;
    }

    // Peek at the top value without removing it
    public int peek() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.peekFirst();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return minStack.peekFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

}

