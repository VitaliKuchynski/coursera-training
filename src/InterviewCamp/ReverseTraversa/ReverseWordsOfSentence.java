package InterviewCamp.ReverseTraversa;

public class ReverseWordsOfSentence {

    public static void main(String[] args) {

        System.out.println(reverseWord("i live in a house"));

    }


    public static String reverseWord(String s) {

        StringBuilder builder = new StringBuilder();
        int currentWordEnd = s.length();

        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) == ' ') {
                if (builder.length() > 0) {
                    builder.append(' ');
                }
                builder.append(s.substring(i + 1, currentWordEnd));
                currentWordEnd = i;
            }
        }

        String firstWord = s.substring(0, currentWordEnd);
        if (builder.length() > 0);
        builder.append(' ');
        builder.append(firstWord);

        return builder.toString();

    }

}
