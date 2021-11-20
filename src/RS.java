//import com.charlotte.IntelligentSystems.*;
//
//import java.util.*;
//
//public class RS {
//
//    public static final char OR = '|';
//    public static final char AND = '&';
//    public static final char NEGATION = '!';
//    public static final char IMPLIES = '>';
//    public static final char OPEN_BRACKET = '(';
//    public static final char CLOSE_BRACKET = ')';
//    static boolean isOperator(char c) {
//        return c == OR || c == AND
//                || c == NEGATION || c == IMPLIES;
//    }
//
//    static ExpNode getNode(char c) {
//        return switch (c) {
//            case OR -> new Or(c);
//            case AND -> new And(c);
//            case IMPLIES -> new Implies(c);
//            case NEGATION -> new Not(c);
//            default -> new DataNode(c);
//        };
//    }
//
//    static ExpNode constructTree(char postfix[]) {
//        Stack<ExpNode> st = new Stack<>();
//        ExpNode t, t1 ,t2;
//        for (int i = 0; i < postfix.length; i++) {
//            char c = postfix[i];
//            if (!isOperator(c)) {
//                t = getNode(c);
//                st.push(t);
//            } else {
//                t = getNode(c);
//                t1 = st.pop();
//                t.left_child = null;
//                if(c != NEGATION) {
//                    t2 = st.pop();
//                    t.left_child = t2;
//                }
//                t.right_child = t1;
//                st.push(t);
//            }
//        }
//        t = st.peek();
//        st.pop();
//        return t;
//    }
//
//    static String evaluate(List<ExpNode> left, List<ExpNode> right) {
//        while(true) {
//            boolean found = true;
//            for(ExpNode node: left) {
//                if(right.contains(node)) {
//                    return null;
//                }
//                if(Util.isOperand(node.name)) {
//                    left.remove(node);
//                    List<List<ExpNode>> tree = node.tLeft(left, right);
//                    left = tree.get(0);
//                    right = tree.get(1);
//                    if(tree.size() > 2) {
//                        String v = evaluate(tree.get(2), tree.get(3));
//                        if(v != null) {
//                            return v;
//                        }
//                    }
//                    found = false;
//                    break;
//                }
//            }
//            for(ExpNode node: right) {
//                if(left.contains(node)) {
//                    return null;
//                }
//                if(Util.isOperand(node.name)) {
//                    right.remove(node);
//                    List<List<ExpNode>> tree = node.tRight(left, right);
//                    left = tree.get(0);
//                    right = tree.get(1);
//                    if(tree.size() > 2) {
//                        String v = evaluate(tree.get(2), tree.get(3));
//                        if(v != null) {
//                            return v;
//                        }
//                    }
//                    found = false;
//                    break;
//                }
//            }
//            if(found) {
//                return "Not Tautology";
//            }
//
//        }
//    }
//    static String evaluate(List<ExpNode> tree) {
//        return evaluate(new ArrayList<>(), tree);
//    }
//
//    private boolean runStrategy() {
//        ExpNode root = constructTree(exp.toCharArray());
//        List<ExpNode> expNodeList = new ArrayList<>();
//        expNodeList.add(root);
//        return evaluate(expNodeList) == null;
//
//    }
//
//    public RS transform(boolean isPolishNotation) {
//       exp = isPolishNotation ? ExpressionCovertor.preToPost(exp) : ExpressionCovertor.infixToPostfix(exp);
//       return this;
//    }
//
//    public RS cleanExp() {
//        exp = exp.replaceAll(" ", "")
//                .replaceAll("->", Character.toString(IMPLIES))
//                .replaceAll(Character.toString('['), Character.toString(OPEN_BRACKET))
//                .replaceAll(Character.toString('{'), Character.toString(OPEN_BRACKET))
//                .replaceAll(Character.toString('}'), Character.toString(CLOSE_BRACKET))
//                .replaceAll(Character.toString(']'), Character.toString(CLOSE_BRACKET));
//        return this;
//    }
//
//    public RS(String exp) {
//        this.exp = exp;
//    }
//
//    String exp;
//
//    public static void main(String[] args) {
//        new RS("((a~b)~(!b~!a))")
//                .cleanExp()
//                .transform(false)
//                .runStrategy();
//
////        System.out.println(runStrategy("((a~b)~(!b~!a))", false));
//    }
//}
//
//
