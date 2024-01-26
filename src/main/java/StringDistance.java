public class StringDistance {
    /**
     * <a href="https://leetcode.com/problems/edit-distance/">72. Edit Distance</a>
     * Given two strings word1 and word2, find the minimum number of operations required to transform str1 into str2.
     * The allowed operations are insertion, deletion, and substitution of a character.
     */
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // Create a 2D array to store minimum operations for each prefix of str1 and str2
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
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
