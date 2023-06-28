package InterviewCamp.binaryTree;

public class Node {

    Node left;
    Node right;
    int value;
    // needed for iteratively approach
    boolean visited;
    Node parent;
    // Needed for building tree from linked list
    Node next;

    public Node(int value) {
        super();
        this.value = value;
    }

    public Node getParent() {
        return parent;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
