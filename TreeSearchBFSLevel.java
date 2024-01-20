import java.util.LinkedList;
import java.util.Queue;

public class TreeSearchBFSLevel {

    public static int bfsSearchLevel(TreeNode root, int target) {
        if (root == null)
            return -1; // Target not found

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (current.val == target)
                    return level;

                if (current.left != null)
                    queue.offer(current.left);

                if (current.right != null)
                    queue.offer(current.right);
            }

            level++;
        }

        return -1; // Target not found in the tree
    }

    public static void main(String[] args) {
        // Example Binary Tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(20);

        int targetValue = 7;
        int level = bfsSearchLevel(root, targetValue);

        if (level != -1) {
            System.out.println("Level of value " + targetValue + " is: " + level);
        } else {
            System.out.println("Value " + targetValue + " not found in the tree.");
        }
    }
}
