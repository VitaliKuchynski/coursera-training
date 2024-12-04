package InterviewCamp.arrays.appaysStringII;

public class StringTricks {


    public static void main(String[] args) {

        System.out.println(reverseWords("this is a string".toCharArray()));

    }

// (Level: Easy) Check if a string A is a rotation of another string B. For example, "atbobc" is a rotation of "bobcat"

public static boolean isRotation(String a, String b) {

        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }
         return (a + a).contains(b);
}


// (Level: Easy) Reverse the words in a sentence. For example,


    public static  char[] reverseWords(char[] a) {
        if (a == null) {
            return a;
        }
        reverseChars(a, 0, a.length - 1);
        int wordsStart = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i + 1] == ' ') {
                reverseChars(a, wordsStart, i);
                wordsStart = i + 2;
            }
        }

        reverseChars(a, wordsStart, a.length - 1);

        return a;
    }

    private static void reverseChars(char[] a, int start, int end) {

        if (a == null || !isValidIndex(a, start) || !isValidIndex(a, end)) {
            return;
        }

        while (start < end ) {
            swap(a, start++, end--);
        }

    }

    private static void swap(char[] a, int i, int j) {
        char temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
    private static boolean isValidIndex(char[] a, int i) {
        return i >= 0 && i < a.length;
    }


// (Level: Medium) Find the longest palindromic substring in a string. For example:
}
