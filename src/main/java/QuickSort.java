import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 4, 6};

        System.out.println("Original array: " + Arrays.toString(array));

        quickSort(array, 0, array.length - 1);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(arr, low, high);

            // Recursively sort the sub-arrays
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        // Choose the pivot element (here, we choose the rightmost element)
        int pivot = arr[high];

        // Index of the smaller element
        int i = low - 1;

        // Traverse the array and rearrange elements such that
        // elements smaller than the pivot are on the left,
        // and elements greater than the pivot are on the right
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and pivot (move pivot to its correct position)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // Return the pivot index
        return i + 1;
    }
}
