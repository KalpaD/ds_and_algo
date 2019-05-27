
public class SelectionSort {

    public void sort(int [] array) {

        for (int i = 0; i < array.length; i++) {

            // find the min and min index
            int min = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {

                if (min > array[j]) {
                    min = array[j];
                    minIndex = j;
                }
            }
            // swap a[i] with a[min]

            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static void main(String [] args) {

        SelectionSort  slectionSort = new SelectionSort();

        int [] array = {10, 12, 4, 5, 6, -1, -5, 12};

        slectionSort.sort(array);

        String s = "";
        for (int i = 0; i < array.length; i++) {
            s = s + " " + array[i];
        }
        System.out.println(s);
    }

}