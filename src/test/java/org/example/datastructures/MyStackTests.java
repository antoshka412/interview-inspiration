package org.example.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTests {

    private MyStack stack;

    @BeforeEach
    public void setUp() {
        stack = new MyStack();
    }

    @Test
    public void testAddAndPeek() {
        stack.add(10);
        assertEquals(10, stack.peek());
        stack.add(20);
        assertEquals(20, stack.peek());
    }

    @Test
    public void testPop() {
        stack.add(1);
        stack.add(2);
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testGetMin() {
        stack.add(5);
        assertEquals(5, stack.getMin());
        stack.add(3);
        assertEquals(3, stack.getMin());
        stack.add(7);
        assertEquals(3, stack.getMin());
        stack.pop(); // removes 7
        assertEquals(3, stack.getMin());
        stack.pop(); // removes 3
        assertEquals(5, stack.getMin());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.add(42);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, stack.size());
        stack.add(1);
        stack.add(2);
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
    }

    @Test
    public void testPopOnEmptyThrowsException() {
        assertThrows(IllegalStateException.class, () -> stack.pop());
    }

    @Test
    public void testPeekOnEmptyThrowsException() {
        assertThrows(IllegalStateException.class, () -> stack.peek());
    }

    @Test
    public void testGetMinOnEmptyThrowsException() {
        assertThrows(IllegalStateException.class, () -> stack.getMin());
    }
}


