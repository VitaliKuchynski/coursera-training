package leetcode;

/**
 * Created by vitalikuchynski on 6/21/20.
 */
public class CountNegatives {

    public static void main(String[] args) {

        int[][] nums = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};

        System.out.println(countNegatives(nums));

    }

    public static int countNegatives(int[][] grid) {

        int count = 0;


        for (int i = 0; i < grid.length ; i++) {

            int[] curAr = grid[i];

            for (int j = 0; j < curAr.length; j++) {

                    if (curAr[j] < 0) {
                    count++;
                }
            }
        }

        return count;
    }

}
