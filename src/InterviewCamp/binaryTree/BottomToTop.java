package InterviewCamp.binaryTree;


public class BottomToTop {

    // Level: Easy Find the height of a binary tree.
    public static int height(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    // Level: Easy Given a binary tree, determine if it is balanced

    public static boolean isBalanced(Node node) {
        return isBalancedHelper(node) != -1;
    }

    public static int isBalancedHelper(Node node) {
        if (node == null) {
            // we are denoting -1 for non balanced tree and 0 for leaf nodes
            return 0;
        }

        int leftHeight = isBalancedHelper(node.getLeft());
        int rightHeight = isBalancedHelper(node.getRight());

        if (leftHeight == -1 || rightHeight == -1) {
            return  -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);

    }
}
