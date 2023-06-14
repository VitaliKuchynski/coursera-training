package InterviewCamp.graph;

public class DeptFirstSearch {

    public static boolean depthFirstSearch(Graph graph, int target) {

        for (Node node: graph.getNodes()) {
            if (node.getState() == State.UNVISITED && dfsVisit(node, target)) {
                return true;
            }
        }
        return false;

    }


    public static boolean dfsVisit(Node node, int target) {
        node.setState(State.VISITING);

        if (node.getData() == target) {
            return true;
        }

        for (Node neighbor: node.getNeighbors()) {
            if (neighbor.getState() == State.UNVISITED && dfsVisit(neighbor, target)) {
                return true;
            }
        }
        node.setState(State.VISITED);
        return false;
    }





}
