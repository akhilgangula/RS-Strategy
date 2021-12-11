package com.uncc.IntelligentSystems;

import com.uncc.TreeUtil.ExpNode;

public class Util {

    public static final char OR = '|';
    public static final char AND = '&';
    public static final char NEGATION = '!';
    public static final char IMPLIES = '>';
    public static final char OPEN_BRACKET = '(';
    public static final char CLOSE_BRACKET = ')';
    public static final char DATA = Character.MAX_VALUE;

    /**
     * Returns true if char is operand
     * ! - negation
     * & - AND
     * | - OR
     * > - placeholder for ->
     *
     * @param c
     * @return ture or false
     */
    static boolean isOperator(char c) {
        return c == OR || c == AND
                || c == NEGATION || c == IMPLIES;
    }

    /**
     * Calculate precedence
     *
     * @param ch
     * @return
     */
    static int getPrecedence(char ch) {
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

    /**
     * Prints sequences of formulas associated with leaves of the tree, only if they are fundamental
     *
     * @param left
     * @param right
     * @param op
     */
    public static void printLeaveFormula(ExpNode left, ExpNode right, char op) {
        if (left == null || right == null) {
            return;
        }
        boolean negateLeft = false, negateRight = false;
        if (left.name == '!') {
            negateLeft = true;
            left = left.right_child;
        }
        if (right.name == '!') {
            negateRight = true;
            right = right.right_child;
        }
        if (isOperator(left.name) || isOperator((right.name))) {
            return;
        }
        System.out.println((negateLeft ? "!" + left : left) + " " + op + " " + (negateRight ? "!" + right : right));
    }
}
