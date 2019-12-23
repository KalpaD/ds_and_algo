public class IncrementInteger {

    /*
        Write a program which takes as input an arrayof digits encoding a nonnegativedecimal 
        integer D and updates the array to represent the integer D + 1.

        {1, 2, 9} -> {1, 3, 0}
    */

    public static int [] incremntArrayInteger(int [] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (i == array.length - 1) {
                array[i] = array[i] + 1;
            }

            if ((array[i] % 10) == 0) {
                array[i] = 0;
                array[i-1] = array[i-1] + 1;
            }
        }
        return array;
    }

    public static void main(String [] args) {
        int [] array = new int [] {1, 0, 9};
        int [] result = incremntArrayInteger(array);
        print(result);
    }

    public static void print(int [] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}