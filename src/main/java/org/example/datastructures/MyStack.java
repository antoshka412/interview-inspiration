package org.example.datastructures;

import java.util.LinkedList;
import java.util.List;

/**
 * Task: To implement own stack of ints using java collection.
 * Stack should include add, pop, peek methods.
 * This stack should support constant time retrieval of the minimum element.
 */
public class MyStack {
    private final List<Integer> list = new LinkedList<>();

    // To support constant time retrieval of the minimum element in a stack, I will use an auxiliary stack
    private final List<Integer> minStack = new LinkedList<>();

    // Add the value at the top of the stack
    public void add(int value) {
        list.addFirst(value);
        if (minStack.isEmpty() || value < minStack.getFirst()) {
            minStack.addFirst(value);
        }
    }

    // Pop the top value from the stack
    public int pop() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int value = list.removeFirst();
        if (value == minStack.getFirst()) {
            minStack.removeFirst();
        }
        return value;
    }

    // Peek at the top value without removing it
    public int peek() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.getFirst();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return minStack.getFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

}

