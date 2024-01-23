import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {5, 2, 8, 1, 9, 4, 6};

        System.out.println("Original array: " + Arrays.toString(nums));
        int l = 0, r = nums.length - 1;
        mergeSort(nums, l, r);

        System.out.println("Sorted array: " + Arrays.toString(nums));
    }

    static void mergeSort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int m = l + (r - l) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    static void merge(int[] arr, int l, int m, int r) {
        int[] a = new int[m - l + 1];
        int[] b = new int[r - m];
        for (int i = 0; i < a.length; i++)
            a[i] = arr[l + i];
        for (int i = 0; i < b.length; i++)
            b[i] = arr[m + 1 + i];
        int k = l, i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] > b[j]) {
                arr[k++] = b[j++];
            } else {
                arr[k++] = a[i++];
            }
        }
        while (i < a.length) {
            arr[k++] = a[i++];
        }
        while (j < b.length) {
            arr[k++] = b[j++];
        }
    }
}
