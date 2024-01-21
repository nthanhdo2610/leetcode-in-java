import java.util.HashSet;
import java.util.Set;

public class SecondSmallestNumber {

    public static int findSecondSmallest(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        if (set.size() < 2) return -1;
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int i : set) {
            if (i < first) {
                second = first;
                first = i;
            } else if (i != first && i <= second) {
                second = i;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        int[] array1 = {5, 2, 8, 1, 3, 7};
        int result1 = findSecondSmallest(array1);
        System.out.println("Second smallest number in the array1: " + result1);

        int[] array2 = {3, 3, 1, 1, 5, 5}; // Duplicate elements
        int result2 = findSecondSmallest(array2);
        System.out.println("Second smallest number in the array2: " + result2);

        int[] array3 = {10}; // Array with one element
        int result3 = findSecondSmallest(array3);
        System.out.println("Second smallest number in the array3: " + result3);

        int[] array4 = {10, 10}; // Duplicate elements
        int result4 = findSecondSmallest(array4);
        System.out.println("Second smallest number in the array4: " + result4);
    }
}
