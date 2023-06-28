package InterviewCamp.binaryTree;

public class BinarySearchTreeSuccessor {
    // 1. If the node has a right child:
    // The successor will be the leftmost node of the right subtree.
    // 2. If there is no right child: The successor for the first parent on the right.
    // To find that, perform a search for the node. We traverse the tree from root to the node and find the ancestor to the right of the node.
    // This is very similar to the Record and Move On technique.
    // 3. If there is no right child or no parent on the right: this is the last node of the tree, there is no successor


    public static Node findSuccessor(Node n, Node root) {

        if (n.getRight() != null) {
            Node current = n.getRight();
            while (current.getLeft() != null) {
                current = current.getLeft();
            }
            return current;
        } else {
            Node current = root, successor = null;
            while (current != null) {
                    if (current.getValue() > n.getValue()) {
                        successor = current;
                        current = current.getLeft();
                    } else if (current.getValue() < n.getValue()) {
                        current = current.getRight();
                    } else if (current == n) {
                        break;
                    }
            }
            return successor;
        }
    }
    // Range Querying: Given a Binary Search Tree, find all the elements in the range [A..B], both A and B inclusive. For example, if we are looking for nodes in the range [5,8] in the following tree:
    // Solution: Find A, or A's successor if A is not in the tree. Then keep finding successors until you exceed B.
}
