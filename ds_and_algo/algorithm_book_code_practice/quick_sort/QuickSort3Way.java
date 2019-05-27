public class QuickSort3Way {


    public void sort(int [] array) {
        sort(array, 0, array.length - 1);
    }

    public void sort(int [] array, int lo, int hi) {

        if (hi <= lo) {
            return;
        }

        int lt = lo;
        int gt = hi;
        int v = array[lo];
        int i = lo;

        while (i <= gt) {

            if (array[i] < v) {
                swap(array, i++, lt++);
            } else if (array[i] > v) {
                swap(array, i, gt--);
            } else {
                i++;
            }
        }

        sort(array, lo, lt - 1);
        sort(array, gt + 1, hi);

    }

    public void swap(int [] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main (String [] args) {

        QuickSort3Way quickSort = new QuickSort3Way();
        //int [] array = {5, 6, 8, 5, 16, 5, 2, 4, 5, 7, 5, 8, 9, 5};
        int [] array = {5, 4, 5, 6, 2, 5, 8};
        quickSort.print(array);
        quickSort.sort(array);
        quickSort.print(array);
    }

    public void print(int array []) {
        String s = "";
        for (int i = 0; i < array.length; i++) {
            s = s + " " + array[i];
        }
        System.out.println(s)

}