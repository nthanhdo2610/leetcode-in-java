public class TreeBSTSearch {

    public static TreeNode search(TreeNode node, int target) {
        // Base case: If the root is null or the target is found
        if (node == null || node.val == target) {
            return node;
        }
        return target < node.val ? search(node.left, target) : search(node.right, target);
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
        TreeNode result = search(root, targetValue);

        if (result != null) {
            System.out.println("Node with value " + targetValue + " found in the BST.");
        } else {
            System.out.println("Node with value " + targetValue + " not found in the BST.");
        }
    }
}
