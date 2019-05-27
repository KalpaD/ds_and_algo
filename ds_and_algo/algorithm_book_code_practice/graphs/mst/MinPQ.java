public class MinPQ<Key extends Comparable<Key>> {

    private Key [] pq;
    private int N;

    public MinPQ(int maxN) {
        pq = (Key []) new Comparable[maxN+1];
    }

    public MinPQ() {
        pq = (Key []) new Comparable[1];
    }

    public MinPQ(Key [] keys) {
        N = keys.length;
        pq = (Key[]) new Comparable[keys.length + 1];
        for (int i = 0; i < N; i++) {
            pq[i+1] = keys[i];
        }
        for (int k = N/2; k >= 1; k--) {
            sink(k);
        }
    }

    public void insert(Key key) {
        if (N == pq.length - 1) {
            resize(2 * pq.length);
        }
        pq[++N] = key;
        swim(N);
    }

    public Key delMin() {
        Key min = pq[1];
        exch(1, N--);
        sink(1);
        pq[N+1] = null;
        if ((N > 0) && (N == (pq.length - 1) / 4 )){
            resize(pq.length / 2);
        }
        return min;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void resize(int capacity) {
        Key [] temp = (Key []) new Comparable[capacity];
        for (int i = 1; i <= N; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    /**
     * Since this is a MinPQ, this make sure smaller value at the top.
     */
    private void swim(int k) {
        while (k > 1 && grater(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    /**
     * Since this is a MinPQ, this make sure larger element to the bottom.
     * To do that we need to find the smallest element and swap it with large one.
     */
    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && grater(j, j+1)) {
                j++; // smaller one is j+1
            }
            if (!grater(k, j)) {
                // k < j, so k is in the corrent location
                break;
            }
            // if not , k > j hence we need to exchange value
            exch(k, j);
            // and keep tracking k
            k = j;
        }
    }

    private boolean grater(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
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
        MinPQ<Integer> minpq = new MinPQ<Integer>(10);

        minpq.insert(2);
        minpq.insert(1);
        minpq.insert(5);
        minpq.insert(7);
        minpq.insert(-1);
        minpq.insert(9);
        minpq.insert(10);
        minpq.insert(8);
        minpq.insert(11);
        minpq.insert(-2);

        minpq.print(minpq.pq);

        System.out.println(minpq.delMin());

        minpq.print(minpq.pq);
        System.out.println(minpq.delMin());

        minpq.print(minpq.pq);
        System.out.println(minpq.delMin());

        minpq.print(minpq.pq);
    }
}