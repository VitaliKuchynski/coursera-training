package InterviewCamp.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    List<Node> neighbors;
    int data;
    State state;
    int level;
    int color;
    int longestPath;

    public Node(int data) {
        super();
        this.neighbors = new ArrayList<>();
        this.data = data;
        this.state = State.UNVISITED;
        this.longestPath = 0;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
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

    public int getLongestPath() {
        return longestPath;
    }

    public void setLongestPath(int longestPath) {
        this.longestPath = longestPath;
    }
}
