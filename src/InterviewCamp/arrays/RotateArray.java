package InterviewCamp.arrays;

public class RotateArray {
// Rotate array by n

    public void rotateArray(int [] ar, int k) {

        k = k % ar.length;

        swap(ar, 0, ar.length - 1);
        swap(ar, 0, k - 1);
        swap(ar, k , ar.length - 1);

    }

    public void swap(int [] ar, int start, int end) {

        while (start < end) {
            int temp = ar[start];
            ar[start] = ar[end];
            ar[end] = temp;
            start++;
            end++;
        }

    }

}
