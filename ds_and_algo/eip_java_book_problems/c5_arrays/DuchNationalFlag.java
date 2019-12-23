
public class DuchNationalFlag {

    /*
        Write a program that takes an array A and an index i into A, and rearranges the elements such that all
        elements such that all elements less than A[i] (pivot) appeat first, 
        followed by elements equal to the pivot, followed by elements grater than the pivot.
    */
    public static int [] duchNationalFlag(int index, int [] array) {
        int pivot = array[index];

        for (int i = 0; i < array.length; i++) {

            for(int j = i + 1; j < array.length; j++) {
                if (array[j] < pivot) {
                    swap(array, i, j);
                    break;
                }
            }
        }

        for (int i = array.length - 1; i >= 0; --i) {

            for (int k = i - 1; k >= 0; --k) {
                if (array[k] > pivot) {
                    swap(array, i, k);
                    break;
                }
            }
        }
        return array;
    }

    public static void main(String [] args) {
        int [] array = new int [] {0, 1, 4, 3, 2, 1, 1, 2, 1, 0};
        int index = 3;
        int [] result  = duchNationalFlag(index, array);
        print(result);
    }

    public static void print(int [] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ,");
        }
    }

    public static void swap(final int[] arr, final int pos1, final int pos2){
        final int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }   
}