package InterviewCamp.graph;

import InterviewCamp.sorts.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteGraphBFS {

  //  Level:Hard Given a graph, separate nodes into 2groups,such that no 2 nodes in the same group have an edge.

    public static Pair<List<Node>>  bipartite(Graph graph) {
        // Set all levels to -1 and states to Unvisited

        for (Node node : graph.getNodes()) {
            node.setState(State.UNVISITED);
            node.setLevel(-1);
        }

        List<Node> group1 = new ArrayList<>();
        List<Node> group2 = new ArrayList<>();

        for (Node node: graph.getNodes()) {

            if (node.getState() == State.UNVISITED) {
                Pair<List<Node>> groups = getBipartiteGroups(node);

                //if any component is not bipartite, graph is not bipartite
                if (groups == null) {
                    return null;
                }

                group1.addAll(groups.getFirst());
                group2.addAll(groups.getSecond());

            }
        }

    return new Pair<List<Node>>(group1, group2);
    }


    public static Pair<List<Node>> getBipartiteGroups(Node start) {
        Queue<Node> q = new LinkedList<>();
        List<Node> oddNodes = new ArrayList<>();
        List<Node> evenNodes = new ArrayList<>();

        q.add(start);
        start.setLevel(0);
        start.setState(State.VISITING);


        while (!q.isEmpty()) {

            Node current = q.remove();

            // process current
            if (current.getLevel() % 2 == 0) {
                evenNodes.add(current);
            } else {
                oddNodes.add(current);
            }

            for (Node neighbor: current.getNeighbors()) {
                if (neighbor.getState() == State.UNVISITED) {
                    neighbor.setLevel(current.getLevel() + 1);
                    q.add(neighbor);
                    neighbor.setState(State.VISITING);
                } else if (neighbor.getLevel() == current.getLevel()) {
                    // odd cycle found
                    return null;
                }
            }
            current.setState(State.VISITED);
        }
        return new Pair<List<Node>>(evenNodes, oddNodes);
    }
}
