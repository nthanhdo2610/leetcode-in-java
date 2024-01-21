public class PowerOfTen {

    /**
     * Write a Java function that takes an integer as input and returns true if the number is a power of 10, and false otherwise.
     * A number is considered a power of 10 if it can be expressed as 10 raised to some non-negative integer power.
     *
     * @param num
     * @return boolean
     */
    public static boolean isPowerOfTen(int num) {
        int i = 1;
        while (i <= num) {
            if (i == num) return true;
            i *= 10;
        }
        return false;
    }

    public static void main(String[] args) {
        // Test the function
        System.out.println(isPowerOfTen(100));  // true
        System.out.println(isPowerOfTen(50));   // false
        System.out.println(isPowerOfTen(1000));  // true
        System.out.println(isPowerOfTen(1));     // true
        System.out.println(isPowerOfTen(200));   // false
    }
}
