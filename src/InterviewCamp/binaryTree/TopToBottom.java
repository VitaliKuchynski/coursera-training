package InterviewCamp.binaryTree;

public class TopToBottom {

    public static void heightTop(Node node) {
        int maxDepth = -1;
        heightTopToBottom(node , -1, maxDepth);
        System.out.println(maxDepth);
    }

    public static void heightTopToBottom(Node node, int parentDepth, Integer maxDepth) {

        if (node == null) {
            return;
        }

        int currentDepth = parentDepth + 1;

        if (currentDepth > maxDepth) {
            maxDepth = currentDepth;
        }

        // left
         heightTopToBottom(node.getLeft(), currentDepth, maxDepth);
        // right
        heightTopToBottom(node.getRight(), currentDepth, maxDepth);

    }
}
