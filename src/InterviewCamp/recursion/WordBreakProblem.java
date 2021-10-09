package InterviewCamp.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreakProblem {

    //WordBreakProblem :
    // Given a String S, which contains letters and no spaces, determine if you can break it into valid words.
    // Return one such combination of words. You can assume that you are provided a dictionary of English words.


    public static void main(String[] args) {

        String str = "ilikemangos";
        HashSet<String> dictionary =  new HashSet<>();
        dictionary.add("i");
        dictionary.add("like");
        dictionary.add("mango");
        dictionary.add("go");
        dictionary.add("to");
        dictionary.add("tango");
        dictionary.add("");


        System.out.println(wordBrake(str, dictionary));

    }

    public static List<String> wordBrake(String str, HashSet<String> dictionary) {

        if (str == null || str.isEmpty()) {
            return null;
        }

        State[] memo = new State[str.length()];
        Arrays.fill(memo, State.UNVISITED);

        List<String> result = new ArrayList<String>();

        if (wordBreak(str, 0, memo, result, dictionary)){
            return result;
        }
        return null;
    }


    public static boolean wordBreak(String s, int start, State[] memo, List<String> result, HashSet<String> dictionary) {

        if (start == s.length()) {
            return true;
        }

        if (memo[start] == State.NOT_FOUND) {
            return false;
        }


        for (int i = start; i < s.length(); i++) {

            String candidate = s.substring(start, i + 1);

            if (dictionary.contains(candidate)) {
                result.add(candidate);

                if (wordBreak(s, i + 1, memo, result, dictionary)) {
                    return true;
                } else {
                    result.remove(result.size() - 1); // remove candidate
                    memo[i + 1] = State.NOT_FOUND;
                }
            }
        }

        return false;

    }


    enum State {
        UNVISITED,
        NOT_FOUND;
    }
}