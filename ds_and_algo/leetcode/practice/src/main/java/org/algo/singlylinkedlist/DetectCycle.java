package org.algo.singlylinkedlist;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle {

    public boolean hasCycle(ListNode head) {

        boolean  hasCycle = false;
        Set<ListNode> nodeSet = new HashSet<>();

        ListNode current = head;
        while (current != null) {

            if (!nodeSet.contains(current)) {
                nodeSet.add(current);
            }
            else {
                hasCycle = true;
                break;
            }

            current = current.next;
        }

        return hasCycle;
    }
}
