public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        int i = 0, j = 0, k = 0;
        int[] arr = new int[n + m];
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                arr[k++] = arr1[i++];
            } else {
                arr[k++] = arr2[j++];
            }
        }
        while (i < n) {
            arr[k++] = arr1[i++];
        }
        while (j < m) {
            arr[k++] = arr2[j++];
        }
        int t = k / 2;
        if (k % 2 == 0) {
            return (double) (arr[t] + arr[t - 1]) / 2;
        } else {
            return arr[t];
        }
    }

    public static void main(String[] args) {

        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }
}
