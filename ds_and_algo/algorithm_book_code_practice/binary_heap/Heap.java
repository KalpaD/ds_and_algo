public class Heap<Key extends Comparable<Key>> {

    private Key [] heap;
    private int N;

    Heap() {
        heap = (Key [])new Comparable[13];
    }

    /**
     * Keep the heap order by making a lerger inserted value 
     * to swim up the it's correct position in the heap tree.
     * Bottom-Up reheapify.
     */
    private void swim(int k) {

        // k should be grater than 1 since heap only exists fro k > 1
        // and until parent (k/2) > k current child this loop goes on.
        while (k > 1 && less(k/2, k)) {
            exch(k/2, k);
            // move k to k/2 (parent)
            k = k/2;
        }
    }

   
    private void sink(int k) {
       //     [k]
       //    /   \
       // [2*k] [2*k + 1]
       // hence 2k should be less than or equal to N
        while (2*k <= N) {
            int j = 2*k; // child location
            // j = 2 *k , j + 1 = 2 *k + 1
            // checking child[2*k] < child[2*k + 1]
            // if so increment j ; hence j moves to the larger child node
            if (j < N && less(j, j + 1)) {
                j++;
            }
            // if the value of node[k] > node[2*k]
            // we have to stop the loop k node[k] is in correct location
            if (!less(k, j)) {
                break;
            }

            // since we have found the larger child from 2*k and 2*k + 1
            // if the loop still runing then it means we have skink node[k]
            // note that the j is currently poinitng to the larger child
            exch(k, j);
            // and keep pointing to our value
            k = j;
        }
    }

    public void insert(Key v) {
       heap[++N] = v;
       swim(N);
    }

    public Key delete() {
        Key max = heap[1];
        // remove the top element
       // heap[1] =  null;
        // move the last element to top
        exch(1, N--);

        sink(1);

        heap[N+1] = null;

        return max;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    // exchange pq[i] and pq[j]
    private void exch(int i, int j) {
       Key temp = heap[i];
       heap[i] = heap[j];
       heap[j] = temp;
    }

    public static void main (String args []) {
        Heap heap = new Heap();
        heap.insert(11);    //1
        heap.insert(10);    //2
        heap.insert(9);     //3   
        heap.insert(8);     //4
        heap.insert(7);     //5
        heap.insert(6);     //6
        heap.insert(5);     //7
        heap.insert(4);     //8
        heap.insert(3);     //9
        heap.insert(2);     //10
        heap.insert(1);     //11

        heap.print(heap.heap);

        //heap.insert(20);     //12
        heap.delete();
        heap.print(heap.heap);
    }

    public void print(Key array []) {
        String s = "";
        for (int i = 0; i < array.length; i++) {
            s = s + " " + array[i];
        }
        System.out.println(s);
    }
}