package com.charlotte.IntelligentSystems;

import java.util.ArrayList;
import java.util.List;

public class Not extends ExpNode {
    Not(char c) {
        super(c);
    }

    @Override
    public List<List<ExpNode>> tLeft(List<ExpNode> left, List<ExpNode> right) {
        List<List<ExpNode>> ret = new ArrayList<>();
        ret.add(left);
        List<ExpNode> newRight = new ArrayList<>(right);
        if(right_child != null) {
            newRight.add(right_child);
        }
        ret.add(newRight);
        return ret;
    }

    @Override
    public List<List<ExpNode>> tRight(List<ExpNode> left, List<ExpNode> right) {
        List<List<ExpNode>> ret = new ArrayList<>();
//        List<ExpNode> newLeft = Collections.unmodifiableList(left);
        List<ExpNode> newLeft = new ArrayList<>(left);
        if(right_child != null) {
            newLeft.add(right_child);
        }
        ret.add(newLeft);
        ret.add(right);
        return ret;
    }
}
