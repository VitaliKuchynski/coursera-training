package InterviewCamp.strings;

import java.util.Arrays;

public class FindIfStringAnagram {


    public boolean isAnagram(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        str1 = str1.replace("\\s", "");
        str2 = str2.replace("\\s", "");

        char[] string1 = str1.toCharArray();
        char[] string2 = str2.toCharArray();

        Arrays.sort(string1);
        Arrays.sort(string2);


        return Arrays.equals(string1, string2);


    }
}
