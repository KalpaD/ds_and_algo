public class HeapSort {

    /**
     * Perform the heap sort.
     */
    public void sort(Comparable [] array) {
        // First setp of the heap sort is to construct the heap using
        // arbitory elements in the array.
        int N = array.length;

        // we start the scan halfway back through the array because we can skip the sub heaps of size 1.
        // hence k = N/2
        for (int k = N/2; k >= 1; k--) {
            sink(array, k, N);
        }
        System.out.println("Heap construction done.");
        print(array);

        System.out.println("Sortdown started.");
        // this need to happen while N > 1; since we do not need to touch 0th element N > 1  should be the case.
        while (N > 1) {
            // next step is exchnage max with the last eleme of the heap
            swap(array, 1, N--);
            // it will break the heap order, hence re-heapify.
            sink(array, 1, N);
        }
        System.out.println("Sort completed");
        print(array);
    }

    private void sink(Comparable [] array, int k, int N) {
        //        [k]
        //       /  \
        //     [2*k] [2*k + 1]

        // first need to check existance of the child node
        while (2*k <= N) {

            System.out.println("Executing sink(k = "+k+")");

            int j = 2 * k; // index of the first child

            // need to find which one is larger
            if (j < N && less(array, j, j + 1)) {
                j++; // j becomes [2*k + 1]
            }

            if (!less(array, k, j)) {
                break; // we are done for this node
            }

            //if not it means we have to exchnage array[k] with array[j];
            swap(array, k, j);

            // keep tracking our original k, which is not at jth position.
            k = j;
        }
       print(array);
    }

    /**
    * Note here in this method , it takes the "one-off" approch to support the
    * 1 base indecis of the heap
    *
    */
    public void swap(Comparable [] array, int i , int j) {
        Comparable temp = array[i - 1];
        array[i - 1] = array[j - 1];
        array[j - 1] = temp;
    }

    /**
    * Note here in this method , it takes the "one-off" approch to support the
    * 1 base indecis of the heap
    *   
    */
    public boolean less(Comparable [] array, int i, int j) {
        return array[i-1].compareTo(array[j-1]) < 0;
    }

    public static void main(String [] args) {
        HeapSort heapSort = new HeapSort();

        //String [] array = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        int [] array = {4, 10, 3, 5, 1, 7, 6, 2};
        Comparable [] inputArray = new Comparable[8];

        for(int i = 0; i < array.length; i++) {
            inputArray[i] = array[i];
        }
        heapSort.sort(inputArray);
    }

    public void print(Comparable array []) {
        String s = "";
        for (int i = 0; i < array.length; i++) {
            s = s + " " + array[i];
        }
        System.out.println(s);
    }

}