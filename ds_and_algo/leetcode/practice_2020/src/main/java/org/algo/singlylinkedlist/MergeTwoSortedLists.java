package org.algo.singlylinkedlist;

public class MergeTwoSortedLists {


    public ListNode mergeTwoListsRec(ListNode l1, ListNode l2) {

        if (l1 == null) {
            System.out.println("Returning l2 "+ l2.val);
            return l2;
        } else if (l2 == null) {
            System.out.println("Returning l2 "+ l1.val);
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoListsRec(l1.next, l2);
            System.out.println("Returning l1.val < l2.val "+ l1.val);
            return l1;
        } else {
            l2.next = mergeTwoListsRec(l1, l2.next);
            System.out.println("Returning l1.val > l2.val "+ l2.val);
            return l2;
        }
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode preHead = new ListNode(-1);
        ListNode previous = preHead;
        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                previous.next = l1;
                l1 = l1.next;
            } else {
                previous.next = l2;
                l2 = l2.next;
            }
            previous = previous.next;
        }

        // one of the lists nodes is null
        previous.next = l1 == null ? l2 : l1;

        return preHead.next;
    }
}
