package com.charlotte.IntelligentSystems;/* Java implementation to convert
infix expression to postfix*/
// Note that here we use Stack class for Stack operations

import java.util.Stack;

public class ExpressionCovertor {
    static int Prec(char ch) {
        switch (ch) {
            case Util.OR:
            case Util.AND:
                return 1;

            case Util.NEGATION:
                return 3;
            case Util.IMPLIES:
                return 2;
        }
        return -1;
    }

    static String infixToPostfix(String exp) {
        // initializing empty String for result
        String result = "";

        // initializing empty stack
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);

            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result += c;

                // If the scanned character is an '(',
                // push it to the stack.
            else if (c == '(')
                stack.push(c);

                // If the scanned character is an ')',
                // pop and output from the stack
                // until an '(' is encountered.
            else if (c == ')') {
                while (!stack.isEmpty() &&
                        stack.peek() != '(')
                    result += stack.pop();

                stack.pop();
            } else // an operator is encountered
            {
                while (!stack.isEmpty() && Prec(c)
                        <= Prec(stack.peek())) {

                    result += stack.pop();
                }
                stack.push(c);
            }

        }

        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }

    static String preToPost(String pre_exp) {
        Stack<String> s = new Stack<>();
        int length = pre_exp.length();
        for (int i = length - 1; i >= 0; i--) {
            if (Util.isOperator(pre_exp.charAt(i))) {
                String op1 = s.peek();
                s.pop();
                String temp = null;
                if (pre_exp.charAt(i) != Util.NEGATION) {
                    String op2 = s.peek();
                    s.pop();
                    temp = op1 + op2 + pre_exp.charAt(i);
                } else {
                    temp = op1 + pre_exp.charAt(i);
                }
                s.push(temp);
            } else {
                s.push(pre_exp.charAt(i) + "");
            }
        }
        return s.peek();
    }
}
