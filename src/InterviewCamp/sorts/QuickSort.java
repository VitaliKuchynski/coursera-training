package InterviewCamp.sorts;

import java.util.Arrays;
import java.util.Random;

import static InterviewCamp.selection.SelectionAlg.swap;

public class QuickSort {

    public static void main(String[] args) {
        int [] a = {4,6,1,2,3,5,2,8};

        System.out.println(Arrays.toString(quickSort(a)));
    }

    public static int[] quickSort(int[] a) {

        if (a == null) {
            return null;
        }

        quickSort(a, 0, a.length - 1);

        return a;

    }

    public static void quickSort(int [] a, int start, int end) {
        if (start < 0 || end >= a.length || start >= end) {
            return;
        }

        int pivot = start + (new Random().nextInt(end - start + 1));

        Pair<Integer> points = dutchNationalFlag(a, start, end ,pivot);
        quickSort(a, start, points.getFirst());
        quickSort(a, points.getSecond(), end);



    }

    public static Pair<Integer> dutchNationalFlag(int [] a, int start, int end, int pivotIndex) {

        int pivot = a[pivotIndex];

        int low = start - 1, mid = start - 1, high = end + 1;

        while (mid + 1 < high) {
            if (a[mid + 1] > pivot) {
                swap(a, high - 1, mid + 1);
                high--;
            } else if (a[mid + 1] == pivot) {
                mid++;
            } else {
                swap(a, mid + 1, low + 1);
                mid++;
                low++;
            }
        }

        return new Pair<>(low, high);

    }
}
