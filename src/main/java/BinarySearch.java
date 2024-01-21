public class BinarySearch {

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid; // Target found, return the index
            } else if (array[mid] < target) {
                left = mid + 1; // Search the right half
            } else {
                right = mid - 1; // Search the left half
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int targetValue = 7;

        int result = binarySearch(sortedArray, targetValue);

        if (result != -1) {
            System.out.println("Target value " + targetValue + " found at index " + result);
        } else {
            System.out.println("Target value " + targetValue + " not found in the array.");
        }
    }
}
