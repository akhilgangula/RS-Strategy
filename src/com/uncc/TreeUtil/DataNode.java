package com.uncc.TreeUtil;

import java.util.List;

public class DataNode extends ExpNode implements Traverse {

    public DataNode(char c) {
        super(c);
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
