package udacity;


import java.util.Scanner;

public class loopStringTraversal {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a word: ");
        String word = in.next().toLowerCase();

        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            String letter = word.substring(i, i++);

            if ("aeiouAEIOU".contains(letter)) {
                count++;
            }

        }

        System.out.println(count + " vowels");
    }
}
