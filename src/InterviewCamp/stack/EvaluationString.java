package InterviewCamp.stack;

import java.util.Stack;

// Medium: Determine if the input string has balanced parentheses,
// square brackets, and curly braces "[()]" true, [(]) false

public class EvaluationString {

    public boolean isValid(String expression) {

        Stack<Character> characterStack = new Stack<>();

        for (char ch: expression.toCharArray()) {

            if (ch == '{' || ch == '(' || ch == '[') {
                characterStack.push(ch);
            } else if (ch == '}' || ch == ')' || ch == ']') {

                if (characterStack.isEmpty()) {
                    return false;
                }
                char topChar = characterStack.pop();

                if (!isMatchingPair(topChar, ch)) {
                    return false;
                }
            }
        }
        return characterStack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }

}
