package InterviewCamp.binaryTree;

// Level: Hard Implement Search, Add and Delete operations in a Binary Search Tree.
public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
    }


    public void addNode(int value) {
        Node parent = null;
        Node current = root;

        while (current != null) {
            parent = current;
            // in case if there is a duplicate node, it will end up
            // on the left side.

            current = current.getValue() < value ? current.getRight() : current.getLeft();

            if (parent == null) {
                root = new Node(value);
            } else if (parent.getValue() < value) {
                parent.setRight(new Node(value));
            } else {
                parent.setLeft(new Node(value));
            }
        }
    }

    public Node search(int target) {
        Node current = root;

        while (current !=null) {
            if (current.getValue() < target) {
                current = current.getRight();
            } else if (current.getValue() > target) {
                current = current.getLeft();
            } else {
                return current;
            }
        }
        return null;
    }



    public void deleteNode(Node node, Node parent) {
        if (node.getLeft() == null && node.getRight() == null) {
            replaceChild(parent, node , null);
        } else if (node.getLeft() == null) { // only left is null
            replaceChild(parent, node , node.getRight());
        } else if (node.getRight() == null) {
            replaceChild(parent, node , node.getLeft());
        } else {
            Node successorParent = node;
            Node successor = node.getRight();

            while (successor.getLeft() != null) {
                successorParent = successor;
                successor = successor.getLeft();
            }
            node.setValue(successor.getValue());
            deleteNode(successor, successorParent);
        }
    }

    private void replaceChild (Node parent, Node oldChild, Node newChild) {
        if (parent == null) {  // root node
            root = newChild;
        } else if (parent.getLeft() == oldChild) {
            parent.setLeft(newChild);
        } else if (parent.getRight() == oldChild) {
            parent.setRight(newChild);
        } else {
            throw new IllegalArgumentException("Invalid parent-child");
        }
    }
}

