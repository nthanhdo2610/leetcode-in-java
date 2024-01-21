public class TreeBSTSearch {

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
