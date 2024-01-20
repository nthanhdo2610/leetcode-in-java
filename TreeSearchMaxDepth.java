public class TreeSearchMaxDepth {

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

        TreeSearchMaxDepth treeDepthFinder = new TreeSearchMaxDepth();
        int depth = treeDepthFinder.maxDepth(root);

        System.out.println("Maximum depth of the binary tree: " + depth);
    }
}
