package org.problem.algorythm.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class AddTwoNumbersTests {

    private ListNode buildList(int... values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    private void assertListEquals(ListNode expected, ListNode actual) {
        while (expected != null && actual != null) {
            assertEquals(expected.val, actual.val);
            expected = expected.next;
            actual = actual.next;
        }
        assertNull(expected);
        assertNull(actual);
    }


    @Test
    public void testAddTwoNumbers_basicCases() {
        ListNode l1 = buildList(2, 4, 3);
        ListNode l2 = buildList(5, 6, 4);
        ListNode expectedResult = buildList(7, 0, 8);

        assertEquals(expectedResult, AddTwoNumbers.addTwoNumbers(l1, l2));
    }

    @Test
    public void testDifferentLengths() {
        ListNode l1 = buildList(1, 8);
        ListNode l2 = buildList(0);
        ListNode expected = buildList(1, 8);
        assertListEquals(expected, AddTwoNumbers.addTwoNumbers(l1, l2));
    }

    @Test
    public void testCarryThroughMultipleDigits() {
        ListNode l1 = buildList(9, 9, 9);
        ListNode l2 = buildList(1);
        ListNode expected = buildList(0, 0, 0, 1);
        assertListEquals(expected, AddTwoNumbers.addTwoNumbers(l1, l2));
    }

    @Test
    public void testCarryAddsNewNode() {
        ListNode l1 = buildList(5);
        ListNode l2 = buildList(5);
        ListNode expected = buildList(0, 1);
        assertListEquals(expected, AddTwoNumbers.addTwoNumbers(l1, l2));
    }

    @Test
    public void testOneListNull() {
        ListNode l1 = null;
        ListNode l2 = buildList(1, 2, 3);
        ListNode expected = buildList(1, 2, 3);
        assertListEquals(expected, AddTwoNumbers.addTwoNumbers(l1, l2));
    }

    @Test
    public void testBothZeros() {
        ListNode l1 = buildList(0);
        ListNode l2 = buildList(0);
        ListNode expected = buildList(0);
        assertListEquals(expected, AddTwoNumbers.addTwoNumbers(l1, l2));
    }

    @Test
    public void testLongListCarryPropagation() {
        int n = 100;
        ListNode l1 = buildListN(n, 9); // [9,9,...,9] 100 times
        ListNode l2 = buildList(1);
        ListNode expected = buildList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            1); // One final carry
        assertListEquals(expected, AddTwoNumbers.addTwoNumbers(l1, l2));
    }

    // Helper to build long repeated list
    private ListNode buildListN(int count, int value) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int i = 0; i < count; i++) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }
}


