package org.algo.singlylinkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReturnKthToLastTest {

    private ReturnKthToLast returnKthToLast;

    @BeforeEach
    void setUp() {
        returnKthToLast = new ReturnKthToLast();
    }

    @Test
    void returnKthToLast() {

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.append("a");
        linkedList.append("b");
        linkedList.append("c");
        linkedList.append("d");
        linkedList.append("e");
        linkedList.append("f");
        linkedList.append("g");


        String actual = returnKthToLast.returnKthToLast(linkedList, 3);
        assertEquals("e", actual);

    }
}