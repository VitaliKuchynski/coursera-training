package InterviewCamp.binaryTree;


import static InterviewCamp.binaryTree.BinarySearchTreeDetermineIfBST.isBinarySearchTree;
import static InterviewCamp.binaryTree.BinarySearchTreeRecordTechn.findFirstOccurence;
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

        // Binary search tree
        node4.setLeft(node2);
        node2.setLeft(node1);
        node2.setRight(node3);
        node4.setRight(node6);
        node6.setLeft(node5);

        // Binary search tree
//        root.setLeft(node1);
//        root.setRight(node2);
//        node1.setLeft(node3);
//        node2.setLeft(node4);
//        node2.setRight(node5);
//        node5.setLeft(node6);
//        node5.setRight(node7);
      // heightTop(root);
       // System.out.println(height(root));
        //System.out.println(isBalanced(root));

        // print path
        printPaths(node4);

        System.out.println(isBinarySearchTree(node4));

        System.out.println(findFirstOccurence(node4, 3).getValue());

    }
}
