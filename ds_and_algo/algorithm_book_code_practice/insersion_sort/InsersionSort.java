public class InsersionSort {

    public void sort(int [] array) {
        // outer loop traverse through the main array
        for (int i = 0; i < array.length; i++) {
            // inner loop repeatedly taverse through to find elements larger thatn a[i], if found swap a[i] with a[j].
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j-1]) {
                    swap(array, j, j-1);
                }
            }
        }
    }
    
    public void swap(int [] array, int i, int j) {
         int temp = array[i];
         array[i] = array[j];
         array[j] = temp;
    }

    public static void main(String [] args) {

        InsersionSort insertionSort = new InsersionSort();

        int [] array = {10, 12, 4, 5, 6, -1, -5, 12};

        insertionSort.sort(array);

        String s = "";
        for (int i = 0; i < array.length; i++) {
            s = s + " " + array[i];
        }
        System.out.println(s);
    }
}