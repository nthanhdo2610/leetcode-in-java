public class MaxSumPathMatrix {

    /**
     * For a given matrix find a path with a maximum sum from the most left-bottom node to the most right-top node
     *
     * @param matrix
     * @return
     */
    public static int findMaxSumPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] max = new int[rows][cols];

        // init most left-bottom node
        max[rows - 1][0] = matrix[rows - 1][0];

        // fill the most left column
        for (int i = rows - 2; i >= 0; i--) {
            max[i][0] = matrix[i][0] + max[i + 1][0];
        }

        // fill the most bottom row
        for (int j = 1; j < cols; j++) {
            max[rows - 1][j] = max[rows - 1][j - 1] + matrix[rows - 1][j];
        }

        // fill the rest node
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = 1; j < cols; j++) {
                max[i][j] = matrix[i][j] + Math.max(max[i + 1][j], max[i][j - 1]);
            }
        }

        // retrieve most right-top value
        return max[0][cols - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 7, 9, 2},
                {2, 8, 6, 1},
                {4, 6, 8, 5},
                {2, 11, 3, 4}
        };

        int maxSum = findMaxSumPath(matrix);
        System.out.println("Maximum Sum Path: " + maxSum);
    }
}
