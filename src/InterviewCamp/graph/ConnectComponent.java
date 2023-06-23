package InterviewCamp.graph;

public class ConnectComponent {

    //  (Level: Medium) Given a graph, mark each connected component with a different color

    public static void colorConnectedComponents(Graph graph) {
        int color = 0;


        for (Node node: graph.getNodes()) {
            if (node.getState() == State.UNVISITED) {
                dfsVisit(node, color++);
            }
        }
    }

    public static void dfsVisit(Node node, int color) {
        node.setState(State.VISITING);

        node.setColor(color);

        for (Node neighbor: node.getNeighbors()) {
            if (neighbor.getState() == State.UNVISITED) {
                dfsVisit(neighbor, color);
            }
        }

        node.setState(State.VISITED);

    }
}
