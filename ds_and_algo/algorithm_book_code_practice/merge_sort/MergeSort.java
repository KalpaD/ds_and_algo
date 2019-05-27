public class MergeSort {

    public void sort(int [] array) {

        int [] tempArray = new int [array.length];
        mergeSort(array, tempArray, 0, array.length - 1);

    }
    
    public void mergeSort(int [] array, int [] tempArray, int leftStart, int rightEnd) {

        // exit condition of the recurisive loop.
        if (leftStart >= rightEnd) {
            return;
        }
        // find the mid point
        int mid = (leftStart + rightEnd) / 2;

        // divide left half
        mergeSort(array, tempArray, leftStart, mid);
        // divide right half 
        mergeSort(array, tempArray, mid + 1, rightEnd);
        // then merge
        mergeHalvs(array, tempArray, leftStart, mid, rightEnd);

    }

    public void mergeHalvs(int [] array, int [] tempArray, int leftStart, int mid, int rightEnd) {

        // the provided two halft should be already sorted;
        assert isSorted(array, leftStart, mid);
        assert isSorted(array, mid + 1, rightEnd);

        // copy array to tempArray;
        for (int k = 0; k < array.length; k++) {
            tempArray[k] = array[k];
        }

        int i = leftStart;
        int j = mid + 1;

        // loop through the tempArray
        for (int k = leftStart; k <= rightEnd; k++) {

            if (i > mid) {
                // if index of the left half exhasted, we can just copy items from right half
                array[k] = tempArray[j++];
            } else if (j > rightEnd) {
                // if index of the right half exhasted, we can just copy items from left half
                array[k] = tempArray[i++];
            } else if (tempArray[i] <= tempArray[j]) {
                // if item from the left half is less than or equal to item from the right half
                // then item form the left half get slected
                array[k] = tempArray[i++];
            } else {
                array[k] = tempArray[j++];
            }
        }
    }

    public boolean isSorted(int [] array, int start, int end) {
        for (int i = start; i < end; i++) {
            if (array[i-1] > array[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main (String [] args) {

        MergeSort mergeSort = new MergeSort();
        int [] array = {5, 6, 8, 9, 16, 7, 8, 9, 10, 11};
        mergeSort.print(array);
        mergeSort.sort(array);
        mergeSort.print(array);
    }

    public void print(int array []) {
        String s = "";
        for (int i = 0; i < array.length; i++) {
            s = s + " " + array[i];
        }
        System.out.println(s);
    }
}