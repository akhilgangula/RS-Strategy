package com.uncc.TreeUtil;

public abstract class ExpNode implements Traverse {
    public char name;
    public char op;
    public ExpNode left_child, right_child;

    public ExpNode(char name, ExpNode left_child, ExpNode right_child) {
        this.name = name;
        this.left_child = left_child;
        this.right_child = right_child;
    }

    ExpNode() {
    }

    ExpNode(char name, char op) {
        this.name = name;
        this.op = op;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpNode node = (ExpNode) o;

        if (name != node.name) return false;
        if (left_child != null ? !left_child.equals(node.left_child) : node.left_child != null) return false;
        return right_child != null ? right_child.equals(node.right_child) : node.right_child == null;
    }

    @Override
    public int hashCode() {
        int result = name;
        result = 31 * result + (left_child != null ? left_child.hashCode() : 0);
        result = 31 * result + (right_child != null ? right_child.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return Character.toString(this.name);
    }
}
