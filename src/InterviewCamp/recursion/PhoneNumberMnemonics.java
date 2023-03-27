package InterviewCamp.recursion;


// Level: Medium Phone Number Mnemonics:
// Given an N digit phone number, print all the strings that can be made from that phone number.
// Since 1 and 0 don't correspond to any characters, ignore them.
// For example:
// 213 => AD, AE, AF, BD, BE, BF, CE, CE, CF
// 456 => GJM, GJN, GJO, GKM, GKN, GKO,.. etc.

import java.util.Arrays;

public class PhoneNumberMnemonics {
    public static void main(String[] args) {

       int[] phone =  new int[]{4, 5, 6};
        printWords(phone);
    }

    public static void printWords(int[] phoneNumber) {

        if(phoneNumber == null || phoneNumber.length == 0) {
            return;
        }

        char[] buffer = new char[phoneNumber.length];

        printWordHelper(phoneNumber, buffer, 0,0);
    }

    public static void printWordHelper(int[] a, char[] buffer, int aIndex, int bufferIndex) {


        //termination case
        if (bufferIndex >= buffer.length || aIndex >= a.length) {
            System.out.println(bufferIndex + " - " + Arrays.toString(buffer));
            return;
        }

        //find the candidate for buffer position
        char[] letters = getLetters(a[aIndex]);

        if (letters.length == 0) {
            printWordHelper(a, buffer, aIndex + 1, bufferIndex);
        }

        //place candidate in buffer
        for (char letter : letters) {
            buffer[bufferIndex] = letter;
            printWordHelper(a, buffer, aIndex + 1, bufferIndex + 1);
        }
    }

    public static char[] getLetters(int digit) {
        switch(digit) {
            case 0: return new char[]{};
            case 1: return new char[]{};
            case 2: return new char[]{'a', 'b','c'};
            case 3: return new char[]{'d', 'e','f'};
            case 4: return new char[]{'g', 'h','i'};
            case 5: return new char[]{'j', 'k','l'};
            case 6: return new char[]{'m', 'n','o'};
            case 7: return new char[]{'p', 'q','r','s'};
            case 8: return new char[]{'t','u', 'v'};
            case 9: return new char[]{'w','x', 'y', 'z'};
        }
        throw new IllegalArgumentException("Invalid Digit " + digit);
    }
}