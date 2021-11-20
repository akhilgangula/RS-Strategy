package com.uncc.IntelligentSystems;

public class Util {

    public static final char OR = '|';
    public static final char AND = '&';
    public static final char NEGATION = '!';
    public static final char IMPLIES = '>';
    public static final char OPEN_BRACKET = '(';
    public static final char CLOSE_BRACKET = ')';

    /**
     * Returns true if char is operand
     * ! - negation
     * & - AND
     * | - OR
     * > - placeholder for ->
     * @param c
     * @return ture or false
     */
    static boolean isOperator(char c) {
        return c == OR || c == AND
                || c == NEGATION || c == IMPLIES;
    }

    static int getPrecedence(char ch)
    {
        switch (ch)
        {
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

}
