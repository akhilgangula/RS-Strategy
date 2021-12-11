package com.uncc.TreeUtil;

import com.uncc.IntelligentSystems.Util;

import java.util.List;

public class DataNode extends ExpNode implements Traverse {

    public DataNode(char c) {
        super(c, Util.DATA);
    }

    @Override
    public List<List<ExpNode>> tLeft(List<ExpNode> left, List<ExpNode> right) {
        return null;
    }

    @Override
    public List<List<ExpNode>> tRight(List<ExpNode> left, List<ExpNode> right) {
        return null;
    }
}
