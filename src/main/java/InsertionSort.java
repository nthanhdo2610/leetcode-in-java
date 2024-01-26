import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6};
        System.out.println("Original array: " + Arrays.toString(array));

        insertionSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int num = arr[i];
            int j = i;
            while (j > 0 && num < arr[j - 1]) {
                int tmp = arr[j - 1];
                arr[j - 1] = num;
                arr[j] = tmp;
                j--;
            }
        }
    }
}
