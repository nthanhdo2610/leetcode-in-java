public class TreeTraversalDFS {

    public static void dfs(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        dfs(node.left);
        dfs(node.right);
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
