package org.algo.singlylinkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetectCycleTest {
    private DetectCycle detectCycle;

    @BeforeEach
    void setUp() {
        detectCycle = new DetectCycle();
    }

    @Test
    void hasCycle() {

        ListNode n3 = new ListNode(-4);
        ListNode n2 = new ListNode(0, n3);
        ListNode n1 = new ListNode(2, n2);
        ListNode head1 = new ListNode(3, n1);
        n3.next = n1;

        assertTrue(detectCycle.hasCycle(head1));
    }
}