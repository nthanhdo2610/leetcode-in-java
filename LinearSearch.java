public class LinearSearch {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return the index of the target if found
            }
        }
        return -1; // Return -1 if the target is not found in the array
    }

    public static void main(String[] args) {
        int[] array = {12, 34, 56, 78, 90, 23, 45, 67};
        int targetValue = 45;

        int result = linearSearch(array, targetValue);

        if (result != -1) {
            System.out.println("Target value " + targetValue + " found at index: " + result);
        } else {
            System.out.println("Target value " + targetValue + " not found in the array.");
        }
    }
}
