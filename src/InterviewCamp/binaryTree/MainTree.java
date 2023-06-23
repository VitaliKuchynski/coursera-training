package InterviewCamp.binaryTree;


import static InterviewCamp.binaryTree.BottomToTop.height;
import static InterviewCamp.binaryTree.BottomToTop.isBalanced;
import static InterviewCamp.binaryTree.PrintAllPathFromRoot.printPaths;
import static InterviewCamp.binaryTree.TopToBottom.heightTop;

public class MainTree {

    public static void main(String[] args) {

        Node root = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node5.setRight(node6);
        node6.setRight(node7);
        heightTop(root);
        System.out.println(height(root));
        System.out.println(isBalanced(root));

        // print path
        printPaths(root);

    }
}
