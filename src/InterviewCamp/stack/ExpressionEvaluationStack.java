package InterviewCamp.stack;


//Level:Hard
// Given an arithmetic expression with*,/,-&+ operators and single digit numbers,evaluate it and return the result

import java.util.Stack;

public class ExpressionEvaluationStack {

    public static int evaluateWithParenthesis(char[] expression) {

        if (expression == null || expression.length == 0) {
            return 0;
        }

        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for (char ch : expression) {
            if (isOperand(ch)) {
                operand.push(ch - '0');
            } else if (isOperator(ch)) {
                while (!operator.isEmpty() && precedence(operator.peek()) >= precedence(ch)) {
                    process(operator, operand);
                }
                operator.push(ch);
            } else if (ch =='(') {
                operator.push(ch);
            } else if (ch ==')') {
                while (operator.peek() != '(') {
                        process(operator, operand);
            }
                operator.pop();
        }
    }

        while (!operator.isEmpty()) {
            process(operator, operand);
        }

        return operand.pop();
    }

    private static boolean isOperand(char ch) {
        return (ch >='0') && (ch <='9');
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private static int precedence(char ch) {
        switch (ch) {
            case '/':
            case '*': return 2;
            case '+':
            case '-': return 1;
            case '(':
            case ')': return 0;
            default: throw new IllegalArgumentException("Invalid operator: " + ch);
        }
    }

    private static void process(Stack<Character> operator, Stack<Integer> operand) {

        int num2 = operand.pop();
        int num1 = operand.pop();

        char op = operator.pop();

        int result = 0;

        switch (op) {
            case '/': result = num1 / num2;
            break;
            case '*': result = num1 * num2;
            break;
            case '+': result = num1 + num2;
            break;
            case '-': result = num1 - num2;
            break;
        }
        operand.push(result);
    }

    public static void main(String[] args) {

        char[] expToEval = "1 + 2 / 1 + 3 * 2".toCharArray();
        char[] expToEval1 = "1 + (1 + 3) * 2".toCharArray();
        char[] expToEval2 = "1 + 2 / (1 + 3) * 2".toCharArray();
        char[] expToEval3 = "".toCharArray();

        System.out.println(evaluateWithParenthesis(expToEval3));
    }

}
