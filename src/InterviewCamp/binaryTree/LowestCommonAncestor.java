package InterviewCamp.binaryTree;

public class LowestCommonAncestor {
    // Level: Medium Given 2 nodes of a tree, find their lowest common ancestor (LCA). Assume that each node has a parent pointer.


    public static Node findLCA(Node a, Node b) {
        if (a == null || b  == null) {
            throw new NullPointerException("Input node is null");
        }

        /*
         * Notice pointers to 'a' used {reference in Java}
         * if we had modified 'a', we would have lost node
         */

        Node aPointer = a, bPointer = b;

        // find aDepth
        int aDepth = -1;
        while (aPointer != null) {
            aDepth++;
            aPointer = aPointer.getParent();
        }

        // find bDepth
        int bDepth = -1;
        while (bPointer != null) {
            bDepth++;
            bPointer = bPointer.getParent();
        }

        // Raise the lower node
        Node x = aDepth > bDepth ? a : b;
        for (int i = 0; i < Math.abs(aDepth - bDepth); i++) {
            x = x.getParent();
        }

        // Raise both until they meet (at LCA)
        Node y = aDepth > bDepth ? b : a; // the node that wasn't raised

        while (x != y) {
           x =  x.getRight();
           y =  y.getRight();
        }

        return x; // can return either x or y here
    }


    // Level: MediumLCA without parent pointer: Given 2 nodes of a tree (A and B), find their lowest common ancestor (LCA).
    /*
     * Note: Nodes are denoted final because they should not be reassigned.
     * It isn't good practice adding this, so it impresses the interviewer.
     */

    public static Node findLCA(final Node root, final Node a, final Node b) {
        if (root == null) {
            return null;
        }
        if (root == a || root == b) {
            return root;
        }


        Node leftLCA = findLCA(root.getLeft(), a, b);
        Node rightLCA = findLCA(root.getRight(), a, b);

        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        return leftLCA != null ? leftLCA : rightLCA;
    }

}
