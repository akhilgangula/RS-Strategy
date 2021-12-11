package com.uncc.TreeUtil;

import com.uncc.IntelligentSystems.Util;

import java.util.ArrayList;
import java.util.List;

public class Not extends ExpNode {
    public Not(char c) {
        super(c, Util.NEGATION);
    }

    @Override
    public List<List<ExpNode>> tLeft(List<ExpNode> left, List<ExpNode> right) {
        Util.printLeaveFormula(left_child, right_child, op);
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
        Util.printLeaveFormula(left_child, right_child, op);
        List<List<ExpNode>> ret = new ArrayList<>();
        List<ExpNode> newLeft = new ArrayList<>(left);
        if(right_child != null) {
            newLeft.add(right_child);
        }
        ret.add(newLeft);
        ret.add(right);
        return ret;
    }
}
