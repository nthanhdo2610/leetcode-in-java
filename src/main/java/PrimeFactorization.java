import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeFactorization {

    public static List<Integer> primeFactorization(int n) {
        List<Integer> factors = new ArrayList<>();
        int i = 2;
        while (i <= n) {
            if (n % i == 0) {
                factors.add(i);
                n /= i;
            } else {
                i++;
            }
        }

        return factors;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = sc.nextInt();

        if (number <= 1) {
            System.out.println("Prime factorization is not defined for numbers less than or equal to 1.");
        } else {
            List<Integer> primeFactors = primeFactorization(number);

            System.out.println("Prime factorization of " + number + ": " + primeFactors);
        }

        sc.close();
    }
}
