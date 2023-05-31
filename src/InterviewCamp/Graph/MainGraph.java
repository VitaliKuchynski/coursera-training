package InterviewCamp.Graph;

import java.util.List;

public class MainGraph {

    public static void main(String[] args) {

        Node node1 = new Node(1);

        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        Node node7 = new Node(7);
        Node node8 = new Node(8);

        node1.setNeighbors(List.of(node3, node2));
        node2.setNeighbors(List.of(node4));
        node4.setNeighbors(List.of(node6));
        node3.setNeighbors(List.of(node5, node4));
        node5.setNeighbors(List.of(node6));
        node7.setNeighbors(List.of(node8));

        Graph graph = new Graph(List.of(node1, node2, node3, node4, node5, node6, node7, node8));

        System.out.println(depthFirstSearch(graph, 9));

    }

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
