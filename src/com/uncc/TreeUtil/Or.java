package com.uncc.TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class Or extends ExpNode implements Traverse {

    public Or(char c) {
        super(c);
    }

    @Override
    public List<List<ExpNode>> tLeft(List<ExpNode> left, List<ExpNode> right) {
        List<List<ExpNode>> ret = new ArrayList<>();
        List<ExpNode> newLeft1 = new ArrayList<>(left);
        List<ExpNode> newLeft2 = new ArrayList<>(right);
        newLeft1.add(left_child);
        newLeft2.add(right_child);
        ret.add(newLeft1);
        ret.add(right);
        ret.add(newLeft2);
        ret.add(right);
        return ret;
    }

    @Override
    public List<List<ExpNode>> tRight(List<ExpNode> left, List<ExpNode> right) {
        List<List<ExpNode>> ret = new ArrayList<>();
        ret.add(left);
        List<ExpNode> newRight = new ArrayList<>(right);
        newRight.add(left_child);
        newRight.add(right_child);
        ret.add(newRight);
        return ret;
    }
}
