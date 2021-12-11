package com.uncc.TreeUtil;

import com.uncc.IntelligentSystems.Util;

import java.util.ArrayList;
import java.util.List;

public class Implies extends ExpNode implements Traverse {

    public Implies(char c) {
        super(c, Util.IMPLIES);
    }

    @Override
    public List<List<ExpNode>> tLeft(List<ExpNode> left, List<ExpNode> right) {
        Util.printLeaveFormula(left_child, right_child, op);
        List<List<ExpNode>> ret = new ArrayList<>();
        List<ExpNode> newLeft = new ArrayList<>(left);
        newLeft.add(right_child);
        ret.add(newLeft);
        ret.add(right);
        ret.add(left);
        List<ExpNode> newRight = new ArrayList<>(right);
        newRight.add(left_child);
        ret.add(newRight);
        return ret;
    }

    @Override
    public List<List<ExpNode>> tRight(List<ExpNode> left, List<ExpNode> right) {
        Util.printLeaveFormula(left_child, right_child, op);
        List<List<ExpNode>> ret = new ArrayList<>();
        List<ExpNode> newLeft = new ArrayList<>(left);
        newLeft.add(left_child);
        ret.add(newLeft);
        List<ExpNode> newRight = new ArrayList<>(right);
        newRight.add(right_child);
        ret.add(newRight);
        return ret;
    }
}
