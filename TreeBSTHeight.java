public class TreeBSTHeight {

    public static int findBSTHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = findBSTHeight(root.left);
        int rightHeight = findBSTHeight(root.right);

        // Height is the maximum of left and right subtree heights, plus 1 for the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        // Constructing the binary search tree from the example
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int height = findBSTHeight(root);
        System.out.println("Height of the BST: " + height);
    }
}
