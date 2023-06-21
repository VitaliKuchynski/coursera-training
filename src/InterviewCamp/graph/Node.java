package InterviewCamp.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    List<Node> neighbors;
    int data;
    State state;
    int level;

    public Node(int data) {
        super();
        this.neighbors = new ArrayList<>();
        this.data = data;
        this.state = State.UNVISITED;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Node> neighbors) {
        this.neighbors = neighbors;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
