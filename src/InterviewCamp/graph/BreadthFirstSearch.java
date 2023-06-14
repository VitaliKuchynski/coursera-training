package InterviewCamp.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    public static boolean breadthFirstSearch(Graph graph, int target) {

        for (Node node: graph.getNodes()) {
            if (node.getState() == State.UNVISITED && breadthFirstVisited(node, target)) {
                return true;
            }
        }
        return false;
    }

    public static boolean breadthFirstVisited(Node startNode, int target) {

        Queue<Node> q = new LinkedList<>();
        q.add(startNode);
        startNode.setState(State.VISITING);

        while (!q.isEmpty()) {

            Node current = q.remove();

            if (current.getData() == target) {
                return true;
            }

            for (Node neighbor : current.getNeighbors()) {

                if (neighbor.getState() == State.UNVISITED) {
                    q.add(neighbor);
                    neighbor.setState(State.VISITING);
                }
            }
            current.setState(State.VISITED);
        }
        return false;
    }
}
