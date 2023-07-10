package InterviewCamp.triePrefixTree;

import java.util.HashMap;

public class Node {

    HashMap<Character , Node> map;
    boolean isWord;

    public Node() {
        this.map = new HashMap<>();
        this.isWord = false;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }

    public boolean contains(char ch) {
        return map.containsKey(ch);
    }

    public void addNode(char ch) {
        if (!map.containsKey(ch)) {
            map.put(ch, new Node());
        }
    }

    public Node getNode(char ch) {
        return map.get(ch);
    }

    public HashMap<Character, Node> getMap() {
        return map;
    }
}
