/*
 * ExprTree.java
 *
 * Computer Science S-111, Harvard University
 */

import java.util.*;

/**
 * ExprTree - a class for representing a binary tree that represents
 * an arithmetic expression involving the operators +, -, *, or /.
 * The terms must be single lower-case letters and the expression must
 * be fully parenthesized, e.g.:
 *
 *      (((a + b) * c) + (d - (e / f)))
 */
public class ExpTree {
//    private class Node {
//        private char contents;   // either an arithmetic operator or a..z
//        private Node left;       // left child
//        private Node right;      // right child
//        private boolean negation;
//        /*
//         * isLeaf() - is the specified node a leaf node?
//         */
//        private boolean isLeaf() {
//            return (left == null && right == null);
//        }
//
//        @Override
//        public String toString() {
//            return "Node{" +
//                    "contents=" + contents +
//                    ", left=" + left +
//                    ", right=" + right +
//                    ", negation=" + negation +
//                    '}';
//        }
//    }

    public Node root;
    private Scanner in;
    private final char[] input;
    private int counter;
    public ExpTree(char[] input) {
        root = null;
        this.input = input;
        counter = 0;
    }

    /**
     * inorderPrint - uses infix notation to print the expression tree.
     * It calls inorderPrintTree to perform a recursive inorder traversal.
     */
    public void inorderPrint() {
        if (root != null) {
            inorderPrintTree(root);
            System.out.println();
        }
    }

    /*
     * inorderPrintTree - uses infix notation to print the (sub)tree
     * with the specified root.  It makes recursive calls to print the
     * left and right subtrees of the specified root.
     */
    private static void inorderPrintTree(Node root) {
        if(root == null) {
            return;
        }
        if (root.isLeaf())
            System.out.print(root.contents);
        else {
            // internal node - an operator
            System.out.print("(");
            inorderPrintTree(root.left);
            System.out.print(" " + root.contents + " ");
            inorderPrintTree(root.right);
            System.out.print(")");
        }
    }


    /**
     * readExpression - parses an arithmetic expression entered at the
     * keyboard and builds an expression tree for the expression.  It
     * calls readTree to recursively process the expression.
     */
    public void read() {
        root = readTree();
    }

    /*
     * readTree - recursively parses an arithmetic expression obtained
     * from the user and builds a binary tree for the expression.  The
     * root of the tree is returned.
     */
    public Node readTree() {
        Node n = new Node();

        // get next non-whitespace char
//        char ch = in.findInLine("(\\S)").charAt(0);
        char ch = input[counter++];
        if (isExpression(ch)) {
            n.contents = ch;
            n.left = null;
            n.right = null;
        } else if (ch == '!') {
            n.left = readTree();
            n.contents = ch;
            n.right = null;
        }
        else if (ch == '(') {
            n.left = readTree();
            n.contents = input[counter++];
            n.right = readTree();
            ch = input[counter++];
            if (ch != ')') {
                System.out.println("EXPECTED ) - } ASSUMED...");
                throw new RuntimeException("EXPECTED ) - } ASSUMED...");
            }
        } else {
            char[] temp = Arrays.copyOfRange(input, 0, counter);
            System.out.println("EXPECTED ( - CAN'T PARSE: " + temp);
            throw new RuntimeException("EXPECTED ( - CAN'T PARSE");
        }

        return n;
    }
    public static boolean isExpression(char c) {
        return c >= 'a' && c <= 'z';
    }
    //
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

    /*
     * Program to read an arithmetic expression, convert it to a tree, and
     * print the tree in infix, prefix, and postfix notation.
     */
    public static void main(String[] args) {
        // Read in the expression and build the tree.
        System.out.println("\nType a fully parenthesized expression " +
                "using a..z,|,&,!,=>");
        char[] input = "((a~b)~(!b~!a))".replaceAll(" ", "").toCharArray();
        ExpTree tree = new ExpTree(input);
        tree.read();

        // Output it using all three types of notation.
        System.out.println("\n* INFIX NOTATION:");
        tree.inorderPrint();
    }
}