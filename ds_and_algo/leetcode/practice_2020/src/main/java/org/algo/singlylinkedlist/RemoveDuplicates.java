package org.algo.singlylinkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    public LinkedList removeDups(LinkedList linkedList) {
        Set<Integer> set = new HashSet<>();

        LinkedList.Node current = linkedList.head;
        LinkedList.Node previous = linkedList.head;

        while (current != null) {
            int currentValue = current.val;

            if (set.contains(currentValue)) {
                previous.next = current.next;
            } else {
                set.add(currentValue);
                previous = current;
            }

            current = current.next;
        }

        return linkedList;
    }
}
