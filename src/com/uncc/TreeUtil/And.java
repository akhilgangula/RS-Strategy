package com.uncc.TreeUtil;

import com.uncc.IntelligentSystems.Util;

import java.util.ArrayList;
import java.util.List;

public class And extends ExpNode implements Traverse {

    public And(char c) {
        super(c, Util.AND);
    }

    @Override
    public List<List<ExpNode>> tLeft(List<ExpNode> left, List<ExpNode> right) {
        Util.printLeaveFormula(left_child, right_child, op);
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
        Util.printLeaveFormula(left_child, right_child, op);
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
