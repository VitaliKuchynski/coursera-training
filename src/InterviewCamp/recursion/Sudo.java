package InterviewCamp.recursion;

import java.util.Arrays;

public class Sudo {
    public static void main(String[] args) {

        int[][] board = {
                {1, 0, 0, 6, 0, 7, 0, 8, 0},
                {0, 4, 0, 0, 1, 3, 0, 5, 2},
                {7, 2, 0, 0, 0, 4, 3, 0, 6},
                {2, 0, 9, 0, 5, 0, 0, 0, 0},
                {0, 0, 0, 7, 3, 0, 0, 2, 4},
                {0, 0, 0, 0, 8, 0, 1, 6, 0},
                {0, 1, 2, 0, 6, 0, 5, 0, 7},
                {0, 0, 4, 1, 7, 0, 0, 0, 8},
                {3, 5, 0, 2, 4, 8, 0, 0, 0}
        };


        System.out.println(solveSudoku(board));
    }

    public static boolean solveSudoku(int[][] board) {
        BoardChecker checker = new BoardChecker(board);
        boolean success = solveSudoku(board, 0, 0, checker);
        if (!success) {
            throw new IllegalArgumentException("Board has no solution");

        }
        return success;

    }


    public static boolean solveSudoku(int[][] board, int i, int j, BoardChecker checker) {

        for (int h = 0; h < board.length; h++) {
            System.out.println(Arrays.toString(board[h]));
        }

        System.out.println("------------------------------------");
        System.out.println(" test  i j " + i + " " + j);
        System.out.println("-------------------------------------");



        if (i == board.length) {
            return true;
        }

        Pair next = nextSquare(i, j);

        if (board[i][j] != 0) {
            return solveSudoku(board, next.i(), next.j(), checker);
        }

        for (int candidate = 1; candidate <= 9; candidate++) {

            System.out.println("Test candidate " + candidate);

            if (checker.canPlace(i, j, candidate)) {
                // place candidate on square
                checker.place(i, j, candidate);
                board[i][j] = candidate;

                System.out.println("Test board and candidate " +  board[i][j] + " " + candidate);

                if (solveSudoku(board, next.i(), next.j(), checker)) {
                    return true;
                }
                // remove candidate from square
                checker.remove(i, j, candidate);
                board[i][j] = 0;
            }
        }
        // no solution found
        return false;
    }

    /* * Helper Code: Ask the interviewer if they want you to implement this. */
    public static Pair nextSquare(int i, int j) {

        if (j == 8) {
            return new Pair(i + 1, 0);
        }
        else {
            return new Pair(i, j + 1);
        }
    }

    public static class BoardChecker {
        boolean[][] row = new boolean[9][10];
        boolean[][] column = new boolean[9][10];
        boolean[][] box = new boolean[9][10];

        public BoardChecker(int[][] board) {
            // add existing numbers to checker
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] != 0) {
                        place(i, j, board[i][j]);
                    }
                }
                for (int h = 0; h < row.length; h++) {
                    System.out.println( "row " + Arrays.toString(row[h]));
                }
                System.out.println("-------------------------------------");
                for (int h = 0; h < column.length; h++) {
                    System.out.println("column" + Arrays.toString(column[h]));
                }
                System.out.println("-------------------------------------");
                for (int h = 0; h < box.length; h++) {
                    System.out.println("box" + Arrays.toString(box[h]));
                }
                System.out.println("-------------------------------------");
            }
        }

        public boolean canPlace(int i, int j, int number) {
            System.out.println("-------------------");
            System.out.println("test i j num " + i + " " + j + " : " + number);
            System.out.println(" test row " + row[i][number]);
            System.out.println(" test column " + column[j][number]);
            System.out.println(" test box " + box[boxNumber(i, j)][number]);


            if (row[i][number]) {
                return false;
            }
            if (column[j][number]){
                return false;
            }

            if (box[boxNumber(i, j)][number]) {
                return false;
            }
            return true;
        }

        public boolean place(int i, int j, int number) {
            if (!canPlace(i, j, number)) {
                return false;
            }
            row[i][number] = true;
            column[j][number] = true;
            box[boxNumber(i, j)][number] = true;
            return true;
        }

        public void remove(int i, int j, int number) {
            row[i][number] = false;
            column[j][number] = false;

            box[boxNumber(i, j)][number] = false;
        }

        public int boxNumber(int i, int j) {
            // Note: (i/3) * 3 is not the same as i.
            // for int values, i/3 gets reduced to floor(i/3).
            return (i / 3) * 3 + (j / 3);
        }
    }

    public static class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int i() {
            return i;
        }

        public int j() {
            return j;
        }
    }
}
