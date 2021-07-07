package leetcode;

import java.util.Arrays;

/**
 * Created by vitalikuchynski on 5/29/20.
 */
public class PlusOne {

    public static void main(String[] args) {
                      //0 1 2 3
        int[] digits = {9,9,8,9};

        System.out.println(Arrays.toString(plusOne(digits)));

    }

    public static int[] plusOne(int[] digits) {

        int indicator = 0;
        int [] result = new int[digits.length + 1];

        for (int i = digits.length - 1; i >= 0; i--) {

                if (digits[i] < 9) {
                    digits[i] = digits[i] + 1;
                    break;
                }

                if (indicator == i && digits[i] == 9) {
                    result[i] = 1;
                    return result;
                }

                if (digits[i] == 9) {
                    digits[i] = indicator;
                }
        }

        return digits;
    }

//    public static int[] plusOne(int[] digits) {
//
//        String str = "";
//
//        for (int i = 0; i < digits.length; i++) {
//
//            str = str + String.valueOf(digits[i]);
//        }
//
//        long value = Long.parseLong(str) + 1;
//
//        String temp = String.valueOf(value);
//
//        int [] digitsModf = new int [String.valueOf(value).length()];
//
//        for (int i = 0; i < String.valueOf(value).length(); i++) {
//
//            digitsModf[i] = Integer.parseInt(String.valueOf(temp.charAt(i)));
//
//        }
//
//        return digitsModf;
//    }

//    public static int[] plusOne(int[] digits) {
//
//        int lastNumber = digits[digits.length-1];
//
//        if(digits.length == 1 & lastNumber == 9){
//            int [] digits2 = new int [2];
//            digits2[digits2.length - 2] = digits2[digits2.length - 2] + 1;
//            return digits2;
//        }
//
//
//        if(lastNumber == 9) {
//            digits[digits.length - 1] = 0;
//            digits[digits.length - 2] = digits[digits.length - 2] + 1;
//        }
//
//        if (lastNumber < 9) {
//            digits[digits.length - 1] = lastNumber + 1;
//        }
//
//        return digits;
//    }
}