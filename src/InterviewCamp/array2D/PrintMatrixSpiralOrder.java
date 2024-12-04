package InterviewCamp.array2D;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintMatrixSpiralOrder {

    public static void main(String[] args) {
        int [][] ar = {{1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}};
        int [][] ar1 = {{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}};
        int [][] ar2 = {{6,9,7}};
        int [][] ar3 = {{6},
                        {7},
                        {9}};
        int [][] ar4 = {{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9},
                        {10, 11, 12},
                        {13 ,14, 15}};
        System.out.println(spiralOrder(ar4));
        printSpiral(ar4);

    }

    public static void printSpiral(int[][] a) {

        if (a == null || a.length == 0) {
            return;
        }

        for (int layer = 0; layer < a.length / 2; layer++) {

            printLayer(a, layer, a[0].length - 1 - layer, a.length - 1  - layer);

        }

    }


    private static void printLayer(int[][] a, int layer, int lastColumn, int lastRow) {
        // single element in layer, print separately because other cases won't handle it
//        if (lastColumn == layer && lastRow == layer) {
//            System.out.print(a[layer][layer]);
//        }

        for (int current = layer; current < lastColumn; current++) { //top row
            System.out.print(a[layer][current]);
        }

        for (int current = layer; current < lastRow; current++) { // right column
            System.out.print(a[current][lastColumn]);
        }

        for (int current = lastColumn; current > layer; current--) { // bottom row
            System.out.print(a[lastRow][current]);
        }

        for (int current = lastRow; current > layer; current--) { // left column
            System.out.print(a[current][layer]);
        }


    }

// covered matrix.length == 1, matrix[0].length == 1
    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> outSpiralOrder = new ArrayList<>();

        if(matrix == null || matrix.length == 0) {
            throw new RuntimeException();
        }

        if (matrix.length == 1) {
            for (int current = 0; current < matrix[0].length; current++) {
                outSpiralOrder.add(matrix[0][current]);
            }
        } else if (matrix[0].length == 1) {
            for (int current = 0; current < matrix.length; current++) {
                outSpiralOrder.add(matrix[current][0]);
                // for (int current = matrix.length - 1; current >= 0; current--) {
                //     outSpiralOrder.add(matrix[current][0]);
                // } //from end of column
            }
        }
        else {

            System.out.println(Integer.min(matrix.length, matrix[0].length) / 2);
            for (int layer = 0; layer <= matrix.length  / 2; layer++) {

                putInSpiral(matrix, layer, matrix[0].length - 1 - layer, matrix.length - 1 - layer, outSpiralOrder);

            }
        }


        return outSpiralOrder;
    }

    public static void putInSpiral(int[][] matrix, int layer, int lastColumn, int lastRow, List<Integer> outSpiralOrder) {

        if(layer == lastColumn && layer == lastRow) {
            outSpiralOrder.add(matrix[layer][layer]);
        }


        //top row
        for(int current = layer; current < lastColumn; current++) {
            outSpiralOrder.add(matrix[layer][current]);
        }

        //right column

        for(int current = layer; current < lastRow; current++) {
            outSpiralOrder.add(matrix[current][lastColumn]);
        }

        //bottom row
        for(int current = lastColumn; current > layer; current--) {
            outSpiralOrder.add(matrix[lastRow][current]);
        }

        //left column
        for(int current = lastRow; current > layer; current--) {
            outSpiralOrder.add(matrix[current][layer]);
        }

    }
}
