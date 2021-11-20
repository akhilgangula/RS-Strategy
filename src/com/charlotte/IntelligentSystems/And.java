package com.charlotte.IntelligentSystems;

import java.util.ArrayList;
import java.util.List;

class And extends ExpNode implements Traverse {

    And(char c) {
        super(c);
    }

    @Override
    public List<List<ExpNode>> tLeft(List<ExpNode> left, List<ExpNode> right) {
        List<List<ExpNode>> ret = new ArrayList<>();
        List<ExpNode> newLeft = new ArrayList<>(left);
        newLeft.add(left_child);
        newLeft.add(right_child);
        ret.add(newLeft);
        ret.add(right);
        return ret;
    }

    @Override
    public List<List<ExpNode>> tRight(List<ExpNode> left, List<ExpNode> right) {
        List<List<ExpNode>> ret = new ArrayList<>();
        ret.add(left);
        List<ExpNode> newRight1 = new ArrayList<>(right);
        newRight1.add(left_child);
        ret.add(newRight1);
        ret.add(left);
        List<ExpNode> newRight2 = new ArrayList<>(right);
        newRight2.add(right_child);
        ret.add(newRight2);
        return ret;
    }
}
