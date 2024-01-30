import java.util.Scanner;

public class ScannerCalculateAverage {

    public static void main(String[] args) {
        // Create Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the length of the array
        System.out.print("Enter the length of the array: ");
        int n = scanner.nextInt();

        // Create an array of the specified length
        int[] numbers = new int[n];

        // Prompt user to enter integers for the array
        System.out.println("Enter " + n + " integers:");

        for (int i = 0; i < n; i++) {
            System.out.print("Enter integer #" + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Calculate the average of the numbers in the array
        double average = calculateAverage(numbers);

        // Display the result
        System.out.println("Average of the numbers in the array: " + average);

        // Close the Scanner
        scanner.close();
    }

    // Method to calculate the average of an array of integers
    private static double calculateAverage(int[] array) {
        if (array.length == 0) {
            return 0.0; // To avoid division by zero
        }

        int sum = 0;
        for (int number : array) {
            sum += number;
        }

        return (double) sum / array.length;
    }
}
