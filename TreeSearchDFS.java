public class TreeSearchDFS {

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
