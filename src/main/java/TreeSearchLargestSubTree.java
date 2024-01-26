public class TreeSearchLargestSubTree {

    /**
     * Given a binary tree, find and return the largest tree (subtree) in terms of the number of nodes.
     * @param node
     *        10
     *       / \
     *      5   15
     *     / \    \
     *    1   8    7
     *
     * @return node
     *      5
     *     / \
     *    1   8
     */
    public static TreeNode findLargestTree(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) return node;
        if (node.left == null) return node.right;
        if (node.right == null) return node.left;
        int left = dfs(node.left);
        int right = dfs(node.right);
        return left < right ? node.right : node.left;
    }

    public static int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        return 1 + left + right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);


        TreeNode largestTreeRoot = findLargestTree(root);

        System.out.println("Largest Tree:");
        printTree(largestTreeRoot);
    }

    private static void printTree(TreeNode node) {
        if (node == null) return;
        printTree(node.left);
        System.out.print(node.val + " ");
        printTree(node.right);
    }
}
