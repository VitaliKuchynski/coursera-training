package InterviewCamp.binaryTree;

// Helper for build binary search tree from linked list
public class MedianPair {
    Node median;
    Node previous;

    public MedianPair(Node median, Node previous) {
        this.median = median;
        this.previous = previous;
    }

    public Node getMedian() {
        return median;
    }

    public void setMedian(Node median) {
        this.median = median;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
