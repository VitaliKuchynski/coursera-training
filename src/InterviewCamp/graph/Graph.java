package InterviewCamp.graph;

import java.util.List;

public class Graph {
    List<Node> nodes;

    public Graph(List<Node> nodes) {
        super();
        this.nodes = nodes;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }
}
