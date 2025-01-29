package InterviewCamp.strings;

import java.util.HashMap;
import java.util.Map;

public class FindMaxSubStringUnique {


    public int findMaxUniqueSubstring(String input) {

        if (input.isEmpty()) {
            return -1;
        }
        Map<Character, Integer> seen = new HashMap<>();

        int start = 0;
        int max = 0;

        for (int i = 0; i < input.length(); i++) {

            char currentChar = input.charAt(i);

            if (seen.containsKey(currentChar)){

                start = Math.max(start, seen.get(currentChar) + 1);


            }
            seen.put(currentChar, i);

            max = Math.max(max, i - start + 1);
        }

        return max;
    }


    public String returnMaxUniqueSubstring(String input) {

        if (input.isEmpty()) {
            return null;
        }

        Map<Character, Integer> seen = new HashMap<>();

        int currentMax = 0;
        int start = 0;
        int startMax = 0;


        for (int i = 0; i < input.length(); i++) {

            char currentChar = input.charAt(i);

            if (seen.containsKey(currentChar)) {
                start = Math.max(start, seen.get(currentChar) + 1);
            }

            seen.put(currentChar, i);


            if (i - start + 1 > currentMax) {
                currentMax = i - start + 1;
                startMax = start;
            }

        }
        return input.substring(startMax, startMax + currentMax);

    }


}
