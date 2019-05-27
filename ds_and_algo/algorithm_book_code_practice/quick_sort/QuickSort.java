public class QuickSort {

    public void sort(int [] array) {
        // shuffel here

        sort(array, 0, array.length - 1);
    }

    public void sort(int [] array, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(array, lo, hi);
        sort(array, lo, j-1);
        sort(array, j+1, hi);
    }

    /**
     * Partitioning is the second step of the quick sort.
     *
     * Process of partitioning.
     * 1. Select the first element to be the partitioning element.
     * 2. Have two indices , i and j , where i traverse left to right  and j traverse right to left.
     *    Then we move increment the index i and j respectivily, until a[i] < a[1] , a[j] > a[1]
     *    If we found either of condition violation we stop incremeting it
     *    And wait until other index find a element where it violates the condition, swap the elements.
     * 3. Repeate until i and j cross each other.
     *
     *
     *  The whole idea is to move the elements which are less than to a[1] to it's left and
     *  move elements which are grater than to a[1] to it's right side.
     *
     *
     */
    public int partition_mine(int [] array) {

        int pivot = array[0];
        int i = 1;
        int j = array.length - 1;

        boolean iStoped = false;
        boolean jStoped = false;

        while (i < j) {

            if (pivot > array[i]) {
                i++;
            } else {
                iStoped = true;
            }

            if (pivot < array[j]) {
                j--;
            } else {
                jStoped = true;
            }

            if (iStoped && jStoped) {
                swap(array, i, j);
                i++;
                j--;
                iStoped  = false;
                jStoped  = false;
            }
        }
        //System.out.println("======Move Done==========");
        //print(array);
        // exchange the a[1] with a[j]
        swap(array, 0, j);
        return j;
    }

    public int partition(int [] array, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        while (true) {

            while (array[++i] < array[lo]) {
                if (i == hi) {
                    break;
                }
            }

            while (array[lo] < array[--j]) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            swap(array, i, j);
        }
        swap(array, lo, j);
        return j;
    }

    public void swap(int [] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main (String [] args) {

        QuickSort quickSort = new QuickSort();
        int [] array = {5, 6, 8, 9, 16, 1, 2, 4, 3, 7};
        quickSort.print(array);
        quickSort.sort(array);
        quickSort.print(array);
    }

    public void print(int array []) {
        String s = "";
        for (int i = 0; i < array.length; i++) {
            s = s + " " + array[i];
        }
        System.out.println(s);
    }
}