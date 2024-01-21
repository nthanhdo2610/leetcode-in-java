public class StringDistance {
    /**
     * Problem: Distance Between Strings
     * Given two strings str1 and str2, find the minimum number of operations required to transform str1 into str2.
     * The allowed operations are insertion, deletion, and substitution of a character.
     */
    public static int minDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // Create a 2D array to store minimum operations for each prefix of str1 and str2
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the base cases
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j; // Minimum operations to transform an empty string to str2
                } else if (j == 0) {
                    dp[i][j] = i; // Minimum operations to transform str1 to an empty string
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // Characters match, no additional operation needed
                } else {
                    // Choose the minimum of insert, delete, or substitute operation
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String str1 = "kitten";
        String str2 = "sitting";

        int distance = minDistance(str1, str2);

        System.out.println("Minimum distance between \"" + str1 + "\" and \"" + str2 + "\": " + distance);
    }
}
