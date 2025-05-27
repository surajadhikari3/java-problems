package practisequestions.leetcode.stack;

/*
Valid Parentheses
You are given a string s consisting of the following characters: '(', ')', '{', '}', '[' and ']'.

The input string s is valid if and only if:

Every open bracket is closed by the same type of close bracket.
Open brackets are closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
Return true if s is a valid string, and false otherwise.

Example 1:

Input: s = "[]"

Output: true
Example 2:

Input: s = "([{}])"

Output: true
Example 3:

Input: s = "[(])"

Output: false
* */

import java.util.Stack;

public class BracketMatching {

    public static void main(String[] args) {
//        String s = "([{}])";
        String s = "(])(])";
//        String s = "]]";

        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() % 2 != 0) return false; // not equal then not valid
        boolean isPushed = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
                isPushed = true;
            } else if (!stack.empty()) {
                if (isMatched(stack.peek(), s.charAt(i))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty() && isPushed;
    }

    public static boolean isMatched(Character left, Character right) {
        if (left == '{' && right == '}' || left == '[' && right == ']' || left == '(' && right == ')') {
            return true;
        }
        return false;
    }
}

