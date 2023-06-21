package InterviewCamp.sorts;

import java.util.Arrays;

public class MergeSort {


    public static void main(String[] args) {

        int [] a = {4,6,1,2,3,5,2,8};

        System.out.println(Arrays.toString(mergeSort(a)));
    }

   /* * The two sub arrays to merge are:
   *  a[start..mid]
   *  a[mid+1..end]
   * */

    private static void merge(int [] a, int start, int mid, int end) {



        int [] result = new int[end - start + 1];
        int i = start, j = mid + 1, resultPos = 0;

        while (i <= mid && j <= end) {
           if(a[i] <= a[j]) {
               result[resultPos++] = a[i++];
           } else {
               result[resultPos++] = a[j++];
           }
        }

        // flush remaining elements into result
        while (i <= mid) {
            result[resultPos++] = a[i++];
        }

        while (j <= end) {
            result[resultPos++] = a[j++];
        }

        // copy result into a
        for (int k = 0; k < result.length; k++) {
            a[start + k] = result[k];
        }
    }

    private static void mergeSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + ((end - start) >> 1);
        mergeSort(a, start ,mid);
        mergeSort(a, mid + 1, end);
        merge(a, start, mid ,end);
    }

    public static int[] mergeSort(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }

        mergeSort(a, 0, a.length - 1);
        return a;
    }
}
