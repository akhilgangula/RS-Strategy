//import com.charlotte.IntelligentSystems.ExpressionCovertor;
//import com.charlotte.IntelligentSystems.Util;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
//public class RSStrategy {
//    static Stack<Node> stack = new Stack<>();
//    List<Node> leaves = new ArrayList<>();
//
//    public List<Node> applyRule(char operand, Node left, Node right, boolean negation) {
//        List<Node> ret = new ArrayList<>();
//        if(operand == '|' || operand == '&') {
//            if(negation) {
//                left.negation =true;
//                right.negation = true;
//            }
//            ret.add(right);
//            ret.add(left);
//        } else if(operand == '~') {
//            if(negation) {
//                right.negation = true;
//            } else {
//
//                left.negation = true;
//            }
//            ret.add(right);
//            ret.add(left);
//        } else if(operand == '!') {
//            if (!negation) {
//                left.negation = true;
//            }
//            ret.add(left);
//        }
//        if(Util.isExpression(operand)) {
//            System.out.println("Complete: " +(negation ? "!"+operand: operand));
//            this.leaves.add(new Node(operand, negation));
//        }
//        return ret;
//    }
//    private void applyStrategy(Node root){
//        List<Node> nodes = applyRule(root.contents, root.left, root.right, root.negation);
////        System.out.println("When root.contents is: "+ root.contents + " => " +nodes);
//        nodes.forEach(node -> stack.push(node));
//        while (!stack.empty()) {
//            applyStrategy(stack.pop());
//        }
//    }
//
//    public static boolean runStrategy(String expression) {
//        String postFix = ExpressionCovertor.infixToPostfix(expression);
//        ExpressionTree et = new ExpressionTree();
//        Node root = et.constructTree(postFix.toCharArray());
////        et.inorder(root);
//        RSStrategy rsStrategy = new RSStrategy();
//        rsStrategy.applyStrategy(root);
//        List<Node> result = rsStrategy.leaves;
//        for(Node node: result) {
//            Node node1 = node.copy();
//            node1.negation = !node1.negation;
//            if(result.contains(node1)) {
//                return true;
//            }
//        }
//        return false;
//    }
//    public static void main(String[] args) {
////        String expression = "(((a~b)&!c|(a~c)))";
//
//            System.out.println(runStrategy("(((a~b)&!c|(a~c)))"));
//
//    }
//}