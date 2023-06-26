package InterviewCamp.binaryTree;

import java.util.HashMap;

public class ReconstructionTree {

    // Level: Hard Given inorder and preorder traversals of a binary tree, reconstruct the binary tree.
    // should not have duplicates
    // cannot be used preorder and postorder technique  only inorder and (preorder or postorder) needed to identify root


    public Node buildTree(int []preorder, int [] inorder) {
        HashMap<Integer, Integer> inorderMap = getInorderMap(inorder);
        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }


    public Node construct(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> inorderMap) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // create rood node
        int rootValue = preorder[preStart];
        Node root = new Node(rootValue);


        // find root value's index in inorder traversal
        int k = inorderMap.get(rootValue);

        // add left and right subtrees to root node
        root.left = construct(preorder, preStart + 1, preStart + (k - inStart), inorder, inStart, k - 1, inorderMap);
        root.left = construct(preorder,  preStart + (k - inStart) + 1, preEnd, inorder, k + 1, inEnd, inorderMap);

        return root;
    }

    public HashMap<Integer, Integer> getInorderMap(int [] inorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return inorderMap;
    }
}
