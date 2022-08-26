package InterviewCamp.array2D;

import java.util.Arrays;

public class RotateSquareImage {

    public static void main(String[] args) {
        int [][] ar = {{1, 2, 3, 4},
                      {5, 6, 7, 8},
                      {9, 10, 11, 12},
                      {13, 14, 15, 16}};

        Arrays.stream(rotateMatrixBy90(ar)).forEach(s -> System.out.println(Arrays.toString(s)));
    }



    private static void performMove(int[][] a, int r1, int c1, int r2, int c2, int offset) {

        int temp = a[r1][c1 + offset];
        a[r1][c1 + offset] = a[r2 - offset][c1];
        a[r2 - offset][c1] = a[r2][c2 - offset];
        a[r2][c2 - offset] = a[r1 + offset][c2];
        a[r1 + offset][c2] = temp;


    }

    public static int[][] rotateMatrixBy90(int[][] a) {

        if (a == null || a.length == 0 || a.length != a[0].length) {
            return a;
        }

        int size = a.length;

        for (int i = 0; i < a.length / 2; i++) {
            int r1 = i, c1 = i, r2 = size - r1 - 1, c2 = size - c1 - 1;


            for (int j = 1; j <= c2 - c1; j++) {
                performMove(a, r1, c1, r2, c2, j);
            }
        }
        return a;
    }
}
