public class Util {
    /**
     * Build and return an inorder tree for a @param expression
     * @param expression
     * @return
     */
    public static Node buildTree(char[] expression) {
        Node root = new Node();
        return null;
    }

    /**
     * Returns true if expression, otherwise false
     * @param c
     * @return ture or false
     */
    public static boolean isExpression(char c) {
        return c >= 'a' && c <= 'z';
    }

    /**
     * Returns true if char is operand
     * ! - negation
     * & - AND
     * | - OR
     * ~ - placeholder for ->
     * @param c
     * @return ture or false
     */
    public static boolean isOperand(char c) {
        switch (c) {
            case '!':
            case '&':
            case '|':
            case '~':
                return true;
            default:
                return false;
        }
    }
}
