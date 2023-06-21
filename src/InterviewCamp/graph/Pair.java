package InterviewCamp.graph;

import java.util.List;

public class Pair {
        List<Node> first;
        List<Node> second;

    public Pair(List<Node> first, List<Node> second) {
        this.first = first;
        this.second = second;
    }

    public List<Node> getFirst() {
        return first;
    }

    public List<Node> getSecond() {
        return second;
    }
}
