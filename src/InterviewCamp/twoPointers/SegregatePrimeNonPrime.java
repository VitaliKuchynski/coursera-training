package InterviewCamp.twoPointers;

import java.util.Arrays;

public class SegregatePrimeNonPrime {

    public static void main(String[] args) {
        int[] arr = {1, 8, 2, 3, 4, 5, 7, 20};

        System.out.println(Arrays.toString(segregatePrimeNonPrime(arr)));


    }


    static boolean isPrimeNumber(int number) {

            // Corner case
            if (number <= 1) return false;

            // Check from 2 to n-1
            for (int i = 2; i < number; i++)
                if (number % i == 0)
                    return false;

            return true;
    }

    // Method to segregate the primes
    // and non-primes present in an array
    static int[] segregatePrimeNonPrime(int[] inputArray) {

        int left = 0;
        int right = inputArray.length - 1;

        while (left < right) {

            // Increment left while array
            // element at left is prime
            while (isPrimeNumber(inputArray[left]))
                left++;


            // Decrement right while array
            // element at right is non-prime
            while (!isPrimeNumber(inputArray[right]))
                right--;

            // If left < right, then swap
            // arr[left] and arr[right]
            if (left < right) {

                // Swapp arr[left] and arr[right]
                int temp = inputArray[right];
                inputArray[right] = inputArray[left];
                inputArray[left] = temp;
                left++;
                right--;
            }
        }
        return inputArray;
    }


}

