public class TreeSearchLargest {

    public static int dfs(TreeNode node) {
        if (node == null) return Integer.MIN_VALUE;
        int crr = node.val;
        int maxLeft = dfs(node.left);
        int maxRight = dfs(node.right);
        return Math.max(crr, Math.max(maxLeft, maxRight));
    }

    public static void main(String[] args) {
        // Example Usage:
        // Construct a sample binary tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);

        int largestNode = dfs(root);

        System.out.println("The largest node in the binary tree is: " + largestNode);
    }
}
