package InterviewCamp.arrays.BigInteger;

import java.util.Arrays;

public class BigInteger {


    // Level:Hard You are given two arrays that represent BigIntegers.In such an array, each element in the array is a single digit number.
    public static int[] add(int [] a, int [] b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException();
        }

        int [] large = a.length > b.length ? a : b;
        int [] smaller = large == a ? b : a;
        smaller = resizeWithZero(smaller, large.length);
        int [] result = new int[1 + large.length];
        int carry = 0;

        for (int i = large.length -  1; i >= 0 ; i--) {
            int sum = large[i] + smaller[i] + carry;
            carry = sum / 10;
            result[i + 1] = sum % 10;

        }

        result[0] = carry;
        return trimBeginningZeroes(result);
    }



    public static int[] resizeWithZero(int [] a, int size) {

        if (size <a.length) {
            throw new IllegalArgumentException();
        }

        int[] result = new int[size];
        int aIndex = a.length - 1, resultIndex = result.length - 1;
        while (aIndex >= 0) {
            result[resultIndex] = a[aIndex];
            resultIndex--;
            aIndex--;
        }
        return result;
    }

    public static int[] trimBeginningZeroes(int[] a) {

        int i = 0;
        while (i < a.length && a[i] == 0) {
            i++;
        }

        if (i == a.length) {
            return new int[1]; // return [0]
        }

        return Arrays.copyOfRange(a, i, a.length);
    }

// Level: Hard Q. Multiply two numbers given as Big Integers. In such an array, each element of the array is a single-digit number

    public static int[] multiply(int [] a, int [] b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException();
        }

        int[] result = {0};
        int zeroCount = 0; // number of zeroes to add to the end
        for (int i = a.length - 1; i >= 0 ; i--) {
            int[] product = new int[1 + b.length + zeroCount];
            int carry = 0;

            for (int j = b.length - 1; j >= 0 ; j--) {
                int p = a[i] * b[j] + carry;
                carry = p / 10;
                product[j + 1] = p % 10;
            }

            product[0] = carry;
            result = add(result, product);
            zeroCount++;
        }
        return result;
    }

}
