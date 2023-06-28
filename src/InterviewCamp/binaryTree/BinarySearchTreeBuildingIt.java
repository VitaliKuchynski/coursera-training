package InterviewCamp.binaryTree;

public class BinarySearchTreeBuildingIt {

    // Level:Easy Given a sorted array,build a balanced binary search tree.

    public static TreeNode getTree(int [] a, int start, int end) {
        if (start > end || oob(a, start) || oob(a, end)) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(a[mid]);

        root.setLeft(getTree(a, start, mid - 1));
        root.setRight(getTree(a,mid + 1, end));
        return root;
    }

    // Helper code.
    private static boolean oob(int[] a, int index) {
        return index < 0 || index >= a.length;
    }

    // Level:Medium Given a linked list whose nodes are sorted, turn it into a binary search tree.
    public static TreeNode makeTree(Node head, Node tail) {

        if (head == null || tail == null || tail.next == head) {
            return null;
        }
        MedianPair medianPair = findMedian(head, tail);

        TreeNode root = new TreeNode(medianPair.getMedian().getValue());

        root.setLeft(makeTree(head, medianPair.getPrevious()));
        root.setLeft(makeTree(medianPair.getPrevious().getNext(), tail));

        return root;
    }










    public static MedianPair findMedian(Node head, Node tail) {

        if (head == null || tail == null) {
            return null;
        }
        Node fast = head, slow = head, previousSlow = null;

        while (fast != tail) {
            fast = fast.getNext();
            if (fast != tail) {
                fast = fast.getNext();
                previousSlow = slow;
                slow = slow.getNext();
            }
        }
        return new MedianPair(slow, previousSlow);
    }
}
