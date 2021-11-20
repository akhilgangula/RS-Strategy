package com.uncc.IntelligentSystems;

import com.uncc.TreeUtil.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Strategy {
    static ExpNode getNode(char c) {
        return switch (c) {
            case Util.OR -> new Or(c);
            case Util.AND -> new And(c);
            case Util.IMPLIES -> new Implies(c);
            case Util.NEGATION -> new Not(c);
            default -> new DataNode(c);
        };
    }

    static ExpNode constructTree(char[] postfix) {
        Stack<ExpNode> st = new Stack<>();
        ExpNode t, t1 ,t2;
        for (int i = 0; i < postfix.length; i++) {
            char c = postfix[i];
            if (!Util.isOperator(c)) {
                t = getNode(c);
                st.push(t);
            } else {
                t = getNode(c);
                t1 = st.pop();
                t.left_child = null;
                if(c != Util.NEGATION) {
                    t2 = st.pop();
                    t.left_child = t2;
                }
                t.right_child = t1;
                st.push(t);
            }
        }
        t = st.peek();
        st.pop();
        return t;
    }

    static String evaluate(List<ExpNode> left, List<ExpNode> right) {
        while(true) {
            boolean found = true;
            for(ExpNode node: left) {
                if(right.contains(node)) {
                    return null;
                }
                if(Util.isOperator(node.name)) {
                    left.remove(node);
                    List<List<ExpNode>> tree = node.tLeft(left, right);
                    left = tree.get(0);
                    right = tree.get(1);
                    if(tree.size() > 2) {
                        String v = evaluate(tree.get(2), tree.get(3));
                        if(v != null) {
                            return v;
                        }
                    }
                    found = false;
                    break;
                }
            }
            for(ExpNode node: right) {
                if(left.contains(node)) {
                    return null;
                }
                if(Util.isOperator(node.name)) {
                    right.remove(node);
                    List<List<ExpNode>> tree = node.tRight(left, right);
                    left = tree.get(0);
                    right = tree.get(1);
                    if(tree.size() > 2) {
                        String v = evaluate(tree.get(2), tree.get(3));
                        if(v != null) {
                            return v;
                        }
                    }
                    found = false;
                    break;
                }
            }
            if(found) {
                return "Not Tautology";
            }

        }
    }
    static String evaluate(List<ExpNode> tree) {
        return evaluate(new ArrayList<>(), tree);
    }

    public boolean runStrategy() {
        ExpNode root = constructTree(exp.toCharArray());
        List<ExpNode> expNodeList = new ArrayList<>();
        expNodeList.add(root);
        return evaluate(expNodeList) == null;

    }

    public Strategy normalize(boolean isPolishNotation) {
        exp = isPolishNotation ? ExpressionConvertor.prefixToPostfix(exp) : ExpressionConvertor.infixToPostfix(exp);
        return this;
    }

    public Strategy cleanExp() {
        exp = exp.replaceAll(" ", "")
                .replaceAll("->", Character.toString(Util.IMPLIES))
                .replaceAll("\\[", Character.toString(Util.OPEN_BRACKET))
                .replaceAll("\\{", Character.toString(Util.OPEN_BRACKET))
                .replaceAll("]", Character.toString(Util.CLOSE_BRACKET))
                .replaceAll("}", Character.toString(Util.CLOSE_BRACKET))
                .replaceAll("\\^", Character.toString(Util.AND))
                .replaceAll("~", Character.toString(Util.NEGATION))
                .replaceAll("v", Character.toString(Util.OR));
        return this;
    }

    public Strategy(String exp) {
        this.exp = exp;
    }

    String exp;

    public static void main(String[] args) {
        boolean result = new Strategy("~(a -> c) -> [~(c v d)-> (a ^ ~c)]")
                .cleanExp()
                .normalize(false)
                .runStrategy();
        System.out.println("Is tautology: " + result);
    }
}
