/**
* Search miss require : N compares
* Search hit require :  N Compares in worst case
* Inserting N distincts keys in to empty linked list : ~N^2 compares
*
*/
public class SequentialSearchST<Key, Value> {

    private Node first;

    // The node class represents the linked list node.
    private class Node {
        private Key key;
        private Value value;
        private Node next;

        Node(Key key, Value value, Node next) {
            this.key  = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
    *   This operation doed following
    *   Scan through the list, if key found : update the value
    *   if not, create new node and append it to the start of the list.
    *
    * */
    public void put(Key key, Value value) {
       Node node = first;
       while (node != null) {
            if (node.key.equals(key)) {
                // update the value
                node.value = value;
                return;  // we are done here
            }
            node = node.next;
        }
        // else we create a new one
        Node oldFirst = first;
        first = new Node(key, value, oldFirst);
    }

    public Value get(Key key) {
       Node node = first;
       while (node != null) {
            if (node.key.equals(key)) {
                // update the value
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public void delete(Key key) {
       Node currentNode = first;

       while (currentNode != null) {
            if (currentNode.next.key.equals(key)) {
               currentNode.next = currentNode.next.next;
               return;
            } else {
                currentNode = currentNode.next;
            }
        }

    }

    public boolean contains(Key key) {
        Node node = first;
        while (node != null) {
            if (node.key == key) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return first == null;
    }


    public void print() {
        String result = "";
        Node node = first;
        while (node != null) {
            result = result + "["+node.key+","+node.value+"], ";
            node = node.next;
        }
        System.out.println(result);
    }

    public static void main(String [] args) {
       SequentialSearchST<String, Integer>  sst = new SequentialSearchST<String, Integer>();
       sst.put("A", 1); // inserting values
       sst.put("B", 2);
       sst.put("C", 3);
       sst.put("A", 4); // updating value ; no duplicates
    
       sst.print();

       System.out.println(sst.get("A")); // get existing value
       System.out.println(sst.get("D")); // get non-existing value

       System.out.println(sst.contains("C")); // check for existing value
       System.out.println(sst.contains("E")); // check for non-existing value

       sst.delete("A");

       sst.print();
    }

}