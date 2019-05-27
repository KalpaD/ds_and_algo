public class UnorderedMaxPQ<Key extends Comparable<Key>> {


    private Key [] pq;
    private int N; // number of elements in the queue.

    /**
     * Create an empty priority queue.
     */
    public UnorderedMaxPQ(int capacity) {
        pq = (Key []) new Comparable[capacity];
    }

    /**
     * Insert a key into the priority queue.
     * @param v
     */
    public void insert(Key v) {
        pq[N++] = v;
    }

    /**
     * Return and remove the largest key.
     * @return
     */
    public Key delMax() {
       int maxIndex = getIndexOfMax();
       // move the max value to the end of the array
       exch(pq, maxIndex, N - 1);
       return pq[--N];
    }

    /**
     * Return boolean value os isEmpty.
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * Return the number of entries in the priority queue.
     * @return
     */
    public int size() {
        return N;
    }

    private int getIndexOfMax() {
        int maxIndex = 0;
        for (int i = 0; i < N - 1; i++) {
            if (less(pq[maxIndex], pq[i])) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String [] args) {
        UnorderedMaxPQ unorderedMaxPQ = new UnorderedMaxPQ(10);

        unorderedMaxPQ.insert(2);
        unorderedMaxPQ.insert(1);
        unorderedMaxPQ.insert(5);
        unorderedMaxPQ.insert(7);
        unorderedMaxPQ.insert(-1);
        unorderedMaxPQ.insert(9);
        unorderedMaxPQ.insert(10);
        unorderedMaxPQ.insert(8);
        unorderedMaxPQ.insert(11);
        unorderedMaxPQ.insert(-2);

        unorderedMaxPQ.print(unorderedMaxPQ.pq);

        System.out.println(unorderedMaxPQ.delMax());

        unorderedMaxPQ.print(unorderedMaxPQ.pq);
        System.out.println(unorderedMaxPQ.delMax());

        unorderedMaxPQ.print(unorderedMaxPQ.pq);
        System.out.println(unorderedMaxPQ.delMax());

        unorderedMaxPQ.print(unorderedMaxPQ.pq);

    }

    public void print(Comparable array []) {
        String s = "";
        for (int i = 0; i < array.length; i++) {
            s = s + " " + array[i];
        }
        System.out.println(s);
    }
}
