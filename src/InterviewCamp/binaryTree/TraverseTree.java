package InterviewCamp.binaryTree;

import java.util.Stack;

public class TraverseTree {

    // Traverse preorder
    public static void preOrderVisit(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.getValue());
        preOrderVisit(node.getLeft());
        preOrderVisit(node.getRight());
    }

    // Traverse inorder
    public static void inOrderVisit(Node node) {
        if (node == null) {
            return;
        }

        inOrderVisit(node.getLeft());
        System.out.println(node.getValue());
        inOrderVisit(node.getRight());
    }

    // Traverse postorder
    public static void postOrderVisit(Node node) {
        if (node == null) {
            return;
        }

        postOrderVisit(node.getLeft());
        postOrderVisit(node.getRight());
        System.out.println(node.getValue());
    }

    //Level: Easy Implement inorder traversal iteratively instead of using recursion.

    //With visited Marker
    public static void inOrderIterative(Node root) {

        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            Node node = stack.pop();

            if (node.isVisited()) {
                System.out.println(node.getValue());
            } else {
                node.setVisited(true);

                if (node.getRight() != null) {
                stack.push(node.getRight());
                }

                if (node.getLeft() != null) {
                    stack.push(node.getLeft());
                }
            }
        }
    }

    // Without visited Marker
    public static void inOrderIterativeWithoutMarker(Node root) {

        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node node = root;

        while (node != null || !stack.isEmpty()) {

            if (node != null) {
                stack.push(node);
                node = node.getLeft();
            } else {
                node = stack.pop();
                System.out.println(node.getValue());
                node = node.getRight();
            }
        }
    }


}
