import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinSumPathMatrix {

    /**
     * 64. Minimum Path Sum
     * <a href="https://leetcode.com/problems/minimum-path-sum/description/">...</a>
     */
    static List<PathNode> path = new ArrayList<>();

    public static int findMinSumPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // init the path sum matrix
        int[][] min = new int[rows][cols];
        for (int[] a : min) {
            Arrays.fill(a, 200);
        }

        // init the most top-left node
        min[0][0] = grid[0][0];

        // fill the most left-column
        for (int i = 1; i < rows; i++) {
            min[i][0] = min[i - 1][0] + grid[i][0];
        }

        // fill the most top-row
        for (int j = 1; j < cols; j++) {
            min[0][j] = min[0][j - 1] + grid[0][j];
        }

        // fill the rest nodes
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                min[i][j] = grid[i][j] + Math.min(min[i][j - 1], min[i - 1][j]);
            }
        }

        // Record the path
        int i = 0, j = cols - 1;
        path.add(new PathNode(i, j));
        while (i < rows - 1 || j > 0) {
            if (i == rows - 1) {
                j--;
            } else if (j == 0) {
                i++;
            } else {
                if (min[i + 1][j] < min[i][j - 1]) {
                    i++;
                } else {
                    j--;
                }
            }
            path.add(new PathNode(i, j));
        }

        Collections.reverse(path);
        return min[rows - 1][cols - 1];

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 7, 9, 2},
                {2, 8, 6, 1},
                {4, 6, 8, 5},
                {2, 11, 3, 4}
        };

        int minSum = findMinSumPath(matrix);
        System.out.println("Minimum Sum Path: " + minSum);
        System.out.println("Path: " + path);
    }
}
