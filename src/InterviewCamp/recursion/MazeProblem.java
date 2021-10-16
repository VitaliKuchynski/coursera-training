package InterviewCamp.recursion;

import javax.swing.text.SimpleAttributeSet;
import java.util.Arrays;

public class MazeProblem {

    //Maze Problem: You are given a 2D array that represents a maze.
    // It can have 2 values - 0 and 1.1 represents a wall and 0 represents a path

    public static void main(String[] args) {

        int[][] ints = {{0,1,0,0,0},
                        {0,1,0,1,0},
                        {0,1,0,1,0},
                        {0,0,0,1,0}};

        System.out.println(pathExists(ints));

    }

    public static boolean pathExists(int[][] a) {

        if(a == null || a.length == 0) {
            return false;
        }

        State[][] memo = new State[a.length][a[0].length];

        for (State [] states: memo) {
            Arrays.fill(states, State.UNVISITED);

        }


        return pathExists(a, 0, 0, memo);
    }

    public static boolean pathExists(int[][] a, int i, int j, State[][] memo) {

        for (State [] states: memo) {
            System.out.println(Arrays.toString(states));
        }

        for (int [] as: a) {
            System.out.println(Arrays.toString(as));
        }
        System.out.println("-----------------------------------------");

        if (oob(a, i, j) || a[i][j] == 1) {
            return false;
        }

        if (i == a.length - 1 && j == a[0].length - 1) { // end of maze
            return true;
        }

        if (memo[i][j] == State.NO_PATH_FOUND || memo[i][j] == State.VISITING) {
            return false;
        }
        memo[i][j] = State.VISITING;

        Pair[] points = {
                new Pair(i + 1, j),
                new Pair(i - 1, j),
                new Pair(i, j + 1),
                new Pair(i, j - 1)
        };



        for (Pair point: points) {

            System.out.println(Arrays.toString(points));

            System.out.println("current point" + point.toString());

            if (pathExists(a, point.getFirst(), point.getSecond(), memo)) {
                return true;
            }
        }
        memo[i][j] = State.NO_PATH_FOUND;
        return false;
    }



    private static boolean oob(int[][] a, int i, int j) {
        return i < 0 || i >= a.length || j < 0 || j >= a[0].length;
    }

public enum State {
        UNVISITED,
        VISITING,
        NO_PATH_FOUND;
}



    public static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            super();
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
        }

        @Override
        public String toString() {
            return "["+first+","+second+"]";
        }
    }
}
