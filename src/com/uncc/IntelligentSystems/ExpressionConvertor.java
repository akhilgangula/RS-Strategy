package com.uncc.IntelligentSystems;

import java.util.Stack;


public class ExpressionConvertor {


    /**
     * Convert infix to postfix expression
     *
     * @param exp
     * @return
     */
    static String infixToPostfix(String exp) {
        String result = "";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c))
                result += c;
            else if (c == '(')
                stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() &&
                        stack.peek() != '(')
                    result += stack.pop();
                stack.pop();
            } else {
                while (!stack.isEmpty() && Util.getPrecedence(c)
                        <= Util.getPrecedence(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(c);
            }

        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }

    /**
     * Converts prefix to postfix expression
     *
     * @param pre_exp
     * @return
     */
    static String prefixToPostfix(String pre_exp) {
        Stack<String> s = new Stack<>();
        int length = pre_exp.length();
        for (int i = length - 1; i >= 0; i--) {
            if (Util.isOperator(pre_exp.charAt(i))) {
                String op1 = s.peek();
                s.pop();
                String temp;
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
