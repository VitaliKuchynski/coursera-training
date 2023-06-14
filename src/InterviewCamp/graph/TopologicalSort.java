package InterviewCamp.graph;

import java.util.Stack;

// with no cycle
public class TopologicalSort {



    public static Stack<Node> topologicalSort(Graph graph) {
        Stack<Node> nodeStack = new Stack<>();

        for (Node node: graph.getNodes()) {

            if (node.getState() == State.UNVISITED) {
                dfsVisit(node, nodeStack);
            }
        }
        return nodeStack;

    }

    public static void dfsVisit(Node node, Stack<Node> stack) {

        node.setState(State.VISITING);

        for (Node neighbor: node.getNeighbors()) {
            if (neighbor.getState() == State.UNVISITED) {
                dfsVisit(neighbor, stack);
            }
        }
        node.setState(State.VISITED);
        stack.push(node);

    }

// Level: Hard Diameter of a Graph:
// Given a directed graph, find the length of the longest path in the graph.The path can start from any node.

    public static int diameter(Node start) {

        if (start == null) {
            return 0;
        }

        Stack<Node> topSort = topoSort(start);
        int diameter = 0;

        while (!topSort.isEmpty()){

            Node current = topSort.pop();
            diameter = Math.max(diameter, current.getData());

            for (Node neighbor: current.getNeighbors()) {
                if (current.getData() + 1 > neighbor.getData()) {
                    neighbor.setData(current.getData() + 1);
                }
            }
        }
        return diameter;
    }


    public static Stack<Node> topoSort(Node node) {
        Stack<Node> stack = new Stack<>();
        dfsVisit(node, stack);
        return stack;
    }

}
