package org.algo.singlylinkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDups2Test {
    private RemoveDups2 removeDups2;

    @BeforeEach
    void setUp() {
        removeDups2 = new RemoveDups2();
    }

    @Test
    void deleteDuplicates() {
        ListNode n5 = new ListNode(3, null);
        ListNode n4 = new ListNode(3, n5);
        ListNode n3 = new ListNode(2, n4);
        ListNode n2 = new ListNode(1, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode head1 = new ListNode(1, n1);

        ListNode result = removeDups2.deleteDuplicates(head1);

        List<Integer> resultsList = new ArrayList<>();
        ListNode current = result;
        while (current != null) {
            resultsList.add(current.val);
            current = current.next;
        }

        Integer[] actual = resultsList.toArray(new Integer[0]);
        Integer[] expected = {1, 2, 3};
        assertArrayEquals(expected, actual);

    }
}