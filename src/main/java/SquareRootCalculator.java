import java.util.Scanner;

public class SquareRootCalculator {

    /**
     * Write a Java program that takes a user-inputted number and calculates its square root.
     * Ensure that the program handles cases where the input is negative and provides appropriate feedback.
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a number to find its square root: ");
        int userInput = scanner.nextInt();

        // Check for negative input
        if (userInput < 0) {
            System.out.println("Cannot calculate square root of a negative number.");
        } else {
            // Calculate and display the square root
            double sqrt = Math.sqrt(userInput);
            System.out.println("Square root of " + userInput + " is: " + sqrt);
        }

        // Close the scanner
        scanner.close();
    }
}
