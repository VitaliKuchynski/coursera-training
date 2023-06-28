package InterviewCamp.binaryTree;

public class BinarySearchTreeLCA {
    // Level: Easy Lowest Common Ancestor: Given a Binary Search Tree and 2 nodes A and B, find their lowest common ancestor.
    // You can assume both nodes exist in the tree.


    public static Node findLCA(Node root, Node a, Node b) {

        Node current = root;

        while (current != null) {
            if (current.getValue() < a.getValue() && current.getValue() < b.getValue()) {
                current = current.getRight();
            } else if (current.getValue() > a.getValue() && current.getValue() > b.getValue()) {
                current = current.getLeft();
            } else {
                return current;
            }
        }
        return null;
    }
}
