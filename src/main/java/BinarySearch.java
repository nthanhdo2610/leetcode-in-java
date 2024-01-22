public class BinarySearch {

    public static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (target > array[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
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
