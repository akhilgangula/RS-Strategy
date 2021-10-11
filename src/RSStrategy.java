public class RSStrategy {
    public static void main(String[] args) {
        String expression = "(a|b)->(c|d)";
        Node tree = Util.buildTree(expression.toCharArray());

    }
}
