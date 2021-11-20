package com.charlotte.IntelligentSystems;

import java.util.List;

class DataNode extends ExpNode implements Traverse {

    DataNode(char c) {
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
