package InterviewCamp.array2D;

import java.util.Arrays;

//Level: Medium
// Print a 2D array in Diagonal ZigZag order.
public class ZigZagOrderPrint {


    public static void main(String[] args) {

        int [][] ar = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        printZigZag(ar);

    }

    public static void printZigZag(int[][] a) {

        int row = 0, column = 0;
        boolean up = true;


        //if single row or column, print it out
        if(a.length <= 1 || a[0].length <= 1) {
            System.out.println(Arrays.deepToString(a));
            return;
        }

        while (true) {
            System.out.println(a[row][column]);

            // if boundary, shift to next diagonal, print and change direction
            if ((row == 0 || row == a.length - 1) && column != a[0].length - 1) {
                column++;
                System.out.print(a[row][column]);
                up = !up;
            } else if (column == 0 || column == a[0].length -1) {
                row++;
                System.out.print(a[row][column]);
                up = !up;
            }

            if (row == a.length - 1 && column == a[0].length -1) {
                break;
            }

            // move up or down
            row = up ? row - 1 : row + 1;
            column = up ? column + 1 : column - 1;
        }
    }


}
