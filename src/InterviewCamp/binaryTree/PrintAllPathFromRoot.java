package InterviewCamp.binaryTree;

import java.util.Arrays;
import java.util.Stack;

// Level: Easy Given a Binary Tree, print all paths from root to leaf. For example, in the below tree
public class PrintAllPathFromRoot {

    public static void printPaths(Node root) {
        printPaths(root, new Stack<>());

    }

    public static void printPaths(Node current, Stack<Node> path) {
        if (current == null) {
            return;
        }

        path.add(current);

        if (current.getLeft() == null && current.getRight() == null) {
            path.forEach(node -> System.out.print(node.getValue() + " -> "));
            System.out.println();
        }

        printPaths(current.getLeft(), path);
        printPaths(current.getRight(), path);
        path.pop();
    }
}
