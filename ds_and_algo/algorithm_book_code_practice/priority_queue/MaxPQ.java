/**
 * This is heap based max priority queue implementation.
 */
public class MaxPQ<Key extends Comparable<Key>> {

    private Key [] pq;
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN+1];
    }

    public MaxPQ(Key [] keys) {
        N = keys.length;
        pq = (Key []) new Comparable[keys.length+1];
        // construct the heap 
        for (int i = 0; i < N; i++) {
            pq[i+1] = keys[i];
        }
        // start from k = N/2 to avoid single node mini heaps
        for (int k = N/2; k >= 1; k--) {
            sink(k);
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key key) {
        // add the key to the end of the pq
        pq[++N] = key;
        // let it swim to it's rightful location.
        swim(N);
    }

    public Key delMax() {
        // in a MaxPQ, the max element always lives at top.
        Key max = pq[1];
        // exchanege max with the bottom of the heap
        exch(1, N--);
        // let the new top value sink to it's rightful location.
        sink(1);

        pq[N+1] = null;

        return max;
    }
    
    /**
              [k]
             /  \
        [2*k+1]  [2*k]
      Since this is a MaxPQ, we need to swim the larger elements to top.
     */
    private void swim(int k) {
        // heap only exists for k > 1
        while (k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    /**
     * Since this is a MaxPQ, we need to sink the smaller elements to bottom.
     */
    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(j, j+1)) {
                // then tha larger one should be j+1
                j++;
            }
            if (!less(k, j)) {
                break; // we have find the right place for k
            }
            exch(k, j);
            k = j;
        }
    }

    /**
     * Answer the question , is i < j ?
     */
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public void print(Comparable array []) {
        String s = "";
        for (int i = 0; i < array.length; i++) {
            s = s + " " + array[i];
        }
        System.out.println(s);
    }

    public static void main(String [] args) {
        MaxPQ<Integer> maxpq = new MaxPQ<Integer>(10);

        maxpq.insert(2);
        maxpq.insert(1);
        maxpq.insert(5);
        maxpq.insert(7);
        maxpq.insert(-1);
        maxpq.insert(9);
        maxpq.insert(10);
        maxpq.insert(8);
        maxpq.insert(11);
        maxpq.insert(-2);

        maxpq.print(maxpq.pq);

        System.out.println(maxpq.delMax());

        maxpq.print(maxpq.pq);
        System.out.println(maxpq.delMax());

        maxpq.print(maxpq.pq);
        System.out.println(maxpq.delMax());

        maxpq.print(maxpq.pq);
    }
}