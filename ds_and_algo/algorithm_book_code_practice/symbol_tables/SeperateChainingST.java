package org.kalpads.dsalgo.symbol_tables;

public class SeperateChainingST<Key, Value> {

    private int M = 5;  // number of keys we maintain
    private Node[] st = new Node[M];  // the node array

    private static class Node {
        private Object key;
        private Object val;
        private Node next;

        Node(Object key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    /**
     * The hashCode method will return a positive hashCode between 0 and M -1
     * for a given key.
     *
     * */
    private int hashCode(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(Key key, Value val) {
        int hash = hashCode(key);
        System.out.println("Hash generated : "+ hash +" for key :"+key);
        for (Node x = st[hash]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        // if we have not found a key; then it should be a new key which has no nodes
        // hence creating one
        // note that we are passing st[hash] as the next element
        // when we got the same hash value for diffrent key we just add that as the new elements to the node list
        st[hash] = new Node(key, val, st[hash]);
    }

    public Value get(Key key) {
        int hash = hashCode(key);

        for (Node x = st[hash]; x != null; x = x.next) {
            if (x.key.equals(key)) {
                return (Value)x.val;
            }
        }
        return null;
    }

    public static void main(String [] args) {
        SeperateChainingST<String, Integer> scst = new SeperateChainingST<>();
        scst.put("A", 1);
        scst.put("E", 5);
        scst.put("D", 4);
        scst.put("C", 3);
        scst.put("B", 2);
        scst.put("F", 6);
        scst.put("G", 7);
        scst.put("H", 8);
        scst.put("I", 9);


        System.out.println("get(4) returns : "+scst.get("D"));
    }
}
