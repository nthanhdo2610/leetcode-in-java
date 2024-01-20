import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class MaxDepthBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Recursively calculate the depth of the left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Return the maximum depth among the left and right subtrees, plus 1 for the current level
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        // Example tree:
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        MaxDepthBinaryTree treeDepthFinder = new MaxDepthBinaryTree();
        int depth = treeDepthFinder.maxDepth(root);

        System.out.println("Maximum depth of the binary tree: " + depth);
    }
}

class TreeSearchExample {

    public static int findLevel(TreeNode root, int target) {
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
        int level = findLevel(root, targetValue);

        if (level != -1) {
            System.out.println("Level of value " + targetValue + " is: " + level);
        } else {
            System.out.println("Value " + targetValue + " not found in the tree.");
        }
    }
}
class TreeSearchDFS {

    public static void dfs(TreeNode root) {
        if (root != null) {
            // Process the current node (e.g., print its value)
            System.out.print(root.val + " ");

            // Recursively traverse the left and right subtrees
            dfs(root.left);
            dfs(root.right);
        }
    }

    public static void main(String[] args) {
        // Example Binary Tree
        //      1
        //     / \
        //    2   3
        //   / \
        //  4   5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("DFS traversal of the binary tree:");
        dfs(root);
    }
}
class BSTSearch {

    public static TreeNode searchBST(TreeNode root, int target) {
        // Base case: If the root is null or the target is found
        if (root == null || root.val == target) {
            return root;
        }

        // If the target is smaller than the root's value, search in the left subtree
        if (target < root.val) {
            return searchBST(root.left, target);
        }
        // If the target is larger than the root's value, search in the right subtree
        else {
            return searchBST(root.right, target);
        }
    }

    public static void main(String[] args) {
        // Example usage:
        // Construct a sample BST:
        //       4
        //      / \
        //     2   7
        //    / \
        //   1   3

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int targetValue = 2;
        TreeNode result = searchBST(root, targetValue);

        if (result != null) {
            System.out.println("Node with value " + targetValue + " found in the BST.");
        } else {
            System.out.println("Node with value " + targetValue + " not found in the BST.");
        }
    }
}