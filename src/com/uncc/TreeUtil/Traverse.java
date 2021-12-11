package com.uncc.TreeUtil;


import java.util.List;

interface Traverse {
    List<List<ExpNode>> tLeft(List<ExpNode> left, List<ExpNode> right);

    List<List<ExpNode>> tRight(List<ExpNode> left, List<ExpNode> right);
}