package InterviewCamp.graph;

import java.util.List;

import static InterviewCamp.graph.TopologicalSort.diameter;

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


        Graph graph = new Graph(List.of(node1, node2, node3, node4, node5, node6));

        //topologicalSort(graph).forEach(node -> System.out.println(node.getData()));
        System.out.println(diameter(node1));

    }





}
