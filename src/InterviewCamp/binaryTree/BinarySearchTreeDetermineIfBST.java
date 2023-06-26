package InterviewCamp.binaryTree;

public class BinarySearchTreeDetermineIfBST {
    // Level: Medium Is BST: Given a Binary Tree, determine if it is a Binary Search Tree (BST).

    public static MinMaxPair isBinarySearchTree(Node root) {

        if (root == null) {
            //leaf node is always balanced
            return new MinMaxPair(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        MinMaxPair left = isBinarySearchTree(root.getLeft());
        MinMaxPair right = isBinarySearchTree(root.getRight());

        if (left == null || right == null) {
            return null;
        }

        if (left.getMax() > root.getValue() || right.getMin() < root.getValue()) {
            return null;
        }

        // root is BST , return max and min
        int min = root.getLeft() == null ? root.value : left.getMin();
        int max = root.getRight() == null ? root.value : right.getMax();

        return new MinMaxPair(max, min);
    }


    //Level: Hard Implement Search, Add and Delete operations in a Binary Search Tree.
}
