package org.algo.singlylinkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeTwoSortedListsTest {

    private MergeTwoSortedLists mergeTwoSortedLists;

    @BeforeEach
    void setUp() {
        mergeTwoSortedLists = new MergeTwoSortedLists();
    }

    @Test
    void mergeTwoLists() {
        ListNode l13 = new ListNode(4, null);
        ListNode l12 = new ListNode(2, l13);
        ListNode l1 = new ListNode(1, l12);

        ListNode l23 = new ListNode(4, null);
        ListNode l22 = new ListNode(3, l23);
        ListNode l2 = new ListNode(1, l22);

        ListNode resultsNode = mergeTwoSortedLists.mergeTwoLists(l1, l2);

        int [] expected = {1, 1, 2, 3, 4, 4};
        int [] actual = new int [6];
        int i = 0;
        while (resultsNode != null) {
            actual[i] = resultsNode.val;
            resultsNode = resultsNode.next;
            i++;
        }

        assertArrayEquals(expected, actual);
    }

    @Test
    void mergeTwoListsRec() {
        ListNode l13 = new ListNode(4, null);
        ListNode l12 = new ListNode(2, l13);
        ListNode l1 = new ListNode(1, l12);

        ListNode l23 = new ListNode(4, null);
        ListNode l22 = new ListNode(3, l23);
        ListNode l2 = new ListNode(1, l22);

        ListNode resultsNode = mergeTwoSortedLists.mergeTwoListsRec(l1, l2);

        int [] expected = {1, 1, 2, 3, 4, 4};
        int [] actual = new int [6];
        int i = 0;
        while (resultsNode != null) {
            actual[i] = resultsNode.val;
            resultsNode = resultsNode.next;
            i++;
        }

        assertArrayEquals(expected, actual);
    }
}