import java.util.Objects;

public class Node {
    Node left, right;
    char contents;
    public boolean isLeaf() {
            return (left == null && right == null);
        }

    public Node() {
    }

    public Node(char contents, boolean negation) {
        this.contents = contents;
        this.negation = negation;
    }

    boolean negation;

    @Override
    public String toString() {
        return contents + "";
    }

    public Node copy() {
        Node node = new Node();
        node.contents = contents;
        node.negation = negation;
        node.left = left;
        node.right = right;
        return node;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return contents == node.contents && negation == node.negation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right, contents, negation);
    }
}
