package org.algo.singlylinkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {

    private RemoveDuplicates removeDuplicates;

    @BeforeEach
    void setUp() {
        removeDuplicates = new RemoveDuplicates();
    }

    @Test
    void removeDups() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.append(1);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(3);
        linkedList.append(2);
        linkedList.append(1);
        linkedList.append(3);

        LinkedList<Integer> lList = removeDuplicates.removeDups(linkedList);
        List<Integer> expected = listToArray(lList);

        assertIterableEquals( Arrays.asList(1, 3, 4, 2), expected);

    }

    @Test
    void removeDupsNoDups() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.append(1);
        linkedList.append(3);
        linkedList.append(4);

        LinkedList<Integer> lList = removeDuplicates.removeDups(linkedList);
        List<Integer> expected = listToArray(lList);

        assertIterableEquals(Arrays.asList(1, 3, 4), expected);

    }

    private List<Integer> listToArray(LinkedList<Integer> lList) {
        List<Integer> list = new ArrayList<>();
        LinkedList<Integer>.Node current = lList.head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        return list;
    }


}