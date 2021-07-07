package InterviewCamp;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Map;

public class CountChars {

    public static void main(String[] args) {

        String inputString = "Creating a HashMap containing char";

        countEachCharsInString(inputString);
    }


    public static void countEachCharsInString(String inputStr) {

        char[] strArray = inputStr.replaceAll("\\s", "").toCharArray();

        Map<Character, Integer> characterCount = new HashMap<>();

        for (int i = 0; i < strArray.length; i++) {

            char currentChar = strArray[i];

            if(characterCount.containsKey(currentChar)) {
                characterCount.put(currentChar, characterCount.get(currentChar) + 1);
            } else {
                characterCount.put(currentChar, 1);
            }
        }

//
//        for (Map.Entry entry: characterCount.entrySet()) {
//            System.out.println("Char " + entry.getKey() + " # " + entry.getValue());
//
//        }
            characterCount.entrySet().forEach(System.out::println);

    }
}
