public class ShellSort {

    public void sort(int [] array) {

        int N  = array.length;
        int h = 1;

        // computing the h-sort , size of h;
        // it is based on 3x + 1 formula and h < N/ 3 to be able to keep h within the limits while maximizing the h value.
        while (h < N/3) {
            h = 3 * h + 1; // 1, 4, 13, ...
        }

        // h should be grated than 1 for the sorting.
        while (h >= 1) {
            // i , pointer traverse the array prograsivly
            for (int i = h; i < N ; i++ ) {
                // j , pointer travrse the array in reverse direction by h intervals
                // and it can not go beyond the given h value
                for (int j = i; j >= h; j -= h) {
                    if (array[j] < array[j-h]) {
                        swap(array, j, j-h);
                    }
                }
            }
            // next time when we need h , we just have to h/3;
            h = h/3;
        }
    }

    public void swap(int [] array, int i, int j) {
         int temp = array[i];
         array[i] = array[j];
         array[j] = temp;
    }

    public static void main(String [] args) {

        ShellSort shellSort = new ShellSort();

        int [] array = {10, 12, 4, 5, 6, -1, -5, 12};

        shellSort.sort(array);

        shellSort.print(array);

    }

    public void print(int array []) {
        String s = "";
        for (int i = 0; i < array.length; i++) {
            s = s + " " + array[i];
        }
        System.out.println(s);
    }
}