// Java program to construct an expression tree

import java.util.Stack;

// Java program for expression tree


class ExpressionTree {
    // A utility function to check if 'c'
    // is an operator

    boolean isOperator(char c) {
        return c == '|' || c == '&'
                || c == '!' || c == '~';
    }

    // Utility function to do inorder traversal
    void inorder(Node t) {
        if (t != null) {
            inorder(t.left);
            System.out.print(t.contents + " ");
            inorder(t.right);
        }
    }

    // Returns root of constructed tree for given
    // postfix expression
    Node constructTree(char[] postfix) {
        Stack<Node> st = new Stack<Node>();
        Node t, t1 ,t2;

        // com.charlotte.IntelligentSystems.Util.Traverse through every character of
        // input expression
        for (int i = 0; i < postfix.length; i++) {
            char c = postfix[i];
            // If operand, simply push into stack
            if (!isOperator(c)) {
        t = new Node();

                t.contents = c;
                st.push(t);
            } else // operator
            {
                t = new Node();
                t.contents = c;

                // Pop two top nodes
                // Store top
                t1 = st.pop();	 // Remove top
                t.right = null;
                if(c != '!') {
                    t2 = st.pop();
                    t.right = t2;
                }

                // make them children
                t.left = t1;

                // System.out.println(t1 + "" + t2);
                // Add this subexpression to stack
                st.push(t);
            }
        }

        // only element will be root of expression
        // tree
        t = st.peek();
        st.pop();

        return t;
    }

    public static void main(String[] args) {

        ExpressionTree et = new ExpressionTree();
        String postfix = "ab+ef*g*-";
        char[] charArray = postfix.toCharArray();
        Node root = et.constructTree(charArray);
        System.out.println("infix expression is");
        et.inorder(root);

    }
}

// This code has been contributed by Mayank Jaiswal
