package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubstringUniqueCharacters {
    // (Level: Medium) Given a String, find the longest substring with unique characters.

    public static void main(String[] args) {

        System.out.println(Arrays.toString(allUnique("whatwhywhere")));

    }

    public static int[] allUnique(String inputString) {

        Map<Character, Integer> charCountMap = new HashMap<>();
        int [] result = new int[2];

        int start = 0, end = 0, longest = 1;

        charCountMap.put(inputString.charAt(0), 0);

        while (end < inputString.length() -1) {
            end++;

            char charToAdd = inputString.charAt(end);

            if (charCountMap.containsKey(charToAdd) && charCountMap.get(charToAdd) >= start) {

                    start = charCountMap.get(charToAdd) + 1;
            }
            charCountMap.put(charToAdd, end);

            if (end - start + 1 > longest) {
                longest = end - start + 1;
                result[0] = start;
                result[1] = end;
            }
        }
        System.out.println(inputString.substring(start, end));

        return result;

    }
}
