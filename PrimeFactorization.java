import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {

    public static List<Integer> primeFactorization(int n) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        return factors;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        if (number <= 1) {
            System.out.println("Prime factorization is not defined for numbers less than or equal to 1.");
        } else {
            List<Integer> primeFactors = primeFactorization(number);

            System.out.println("Prime factorization of " + number + ": " + primeFactors);
        }

        scanner.close();
    }
}
