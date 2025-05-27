package practisequestions.leetcode.stack;

import java.util.Stack;

public class ReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                if (!stack.isEmpty()) {
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.push(performOperation(tokens[i], left, right));
                }
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    public static int performOperation(String operand, int left, int right) {
        if (operand.equals("*")) {
            return left * right;
        } else if (operand.equals("/")) {
            return left / right;
        } else if (operand.equals("+")) {
            return left + right;
        } else if (operand.equals("-")) {
            return left - right;
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] tokens = {"1", "2", "+", "3", "*", "4", "-"};
        System.out.println(evalRPN(tokens));
    }
}
