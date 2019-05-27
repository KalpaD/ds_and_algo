/**
     Space and Time Complexity

     push()
        C1 time for the object creation
        2 * C2 time for the varibale reference assingment
        hence C = C1 + C2  ; constant time

     pop()
        C3 time for the varibale reference assingment
        hence C ; constant time

     isEmpty()
        C4 constant time.

     Space
        Node takes following
            16 bytes object overhead
             8 bytes of inner class overhead
             8 bytes of String reference overhead
             8 bytes of node ferenece overhead.
            --
            40 bytes per stack node.
 */
public class Stack {

    private Node first = null;

    private static class Node {
        String item;
        Node next;
    }

    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public String pop() {
        String item = first.item;
        first  = first.next;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String [] args) {

        String item_1 = "Hello";
        String item_2 = "How";
        String item_3 = "Are you ?";

        // simulate the Stack
        Stack stack = new Stack();

        stack.push(item_3);
        stack.push(item_2);
        stack.push(item_1);

        String item1 = stack.pop();
        String item2 = stack.pop();
        String item3 = stack.pop();

        System.out.println(item1+ " " + item2 + " " + item3);
    }

}