package org.algo.singlylinkedlist;

import java.util.NoSuchElementException;

public class ReturnKthToLast {


    public String returnKthToLast(LinkedList<String> linkedList, int k) {
        LinkedList<String>.Node current = linkedList.head;

        while (current != null) {

            LinkedList<String>.Node runner = current;

            for (int i = 0; i < k ; i++) {
                if (runner != null) {
                    runner = runner.next;
                }
                else {
                    throw new NoSuchElementException();
                }
            }

            // we have the runner after k nodes
            if (runner == null) {
                return current.val;
            }
            else {
                current = current.next;
            }
        }

        throw new NoSuchElementException();
    }



}
