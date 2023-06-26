package InterviewCamp.binaryTree;

public class BinarySearchTreeRecordTechn {

// Level: Medium Given a BST that can contain duplicate elements, find the first occurrence of a number N.
    public static Node findFirstOccurence(Node root, int target) {

        Node current = root;
        Node result = null;

        while (current != null) {
            if (current.getValue() > target) {
                current = current.getLeft();
            } else if (current.getValue() < target) {
                current = current.getRight();
            } else {
                result = current;
                current = current.getLeft();
            }
        }
        return result;
    }
}
