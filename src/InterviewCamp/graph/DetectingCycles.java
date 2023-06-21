package InterviewCamp.graph;

// Level: Medium Given a graph, find if there is a cycle.
public class DetectingCycles {


    public static boolean hasCycleDFS(Graph graph) {

        for (Node node: graph.getNodes()) {
            if (node.getState() == State.UNVISITED && visit(node)) {
                return true;
            }
        }
        return false;
    }

    public static boolean visit(Node node) {
         node.setState(State.VISITING);

        for (Node neighbor: node.getNeighbors()) {

            if (neighbor.getState() == State.UNVISITED && visit(neighbor)) {
                return true;
            } else if (neighbor.getState() == State.VISITING) {
                return true;
            }
        }
        node.setState(State.VISITED);
        return false;
    }


}
