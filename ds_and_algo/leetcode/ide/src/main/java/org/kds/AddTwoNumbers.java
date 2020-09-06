package org.kds;

public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int rem = 0;
        ListNode root = new ListNode(0);
        ListNode current = root;
        ListNode p = l1;
        ListNode q = l2;
        while (p != null || q != null) {

            int v1 = (p != null) ? p.val : 0;
            int v2 = (q != null) ? q.val : 0;

            int sum = rem + v1 + v2;
            rem = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if (p != null) {
                p = p.next;
            }

            if (q != null) {
                q = q.next;
            }
        }

        if (rem > 0) {
            current.next = new ListNode(rem);
        }

        return root.next;
    }


    private void run() {
        //[2,4,3]
        //[5,6,4]
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;
        l3.next = null;

        ListNode lv1 = new ListNode(5);
        ListNode lv2 = new ListNode(6);
        ListNode lv3 = new ListNode(4);

        lv1.next = lv2;
        lv2.next = lv3;
        lv3.next = null;

        ListNode res = addTwoNumbers(l1, lv1);

        while (res != null) {
            System.out.print(res.val);
            if (res != null) {
                res = res.next;
            }
        }
    }

    public static void main(String [] args) {
        AddTwoNumbers add = new AddTwoNumbers();
        add.run();

        char [] chars = new char [5];

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 0) {
                System.out.println("empty");
            }
            System.out.println(chars[i]);
        }
    }
}
