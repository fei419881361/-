package com.company.zlf.btree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.cnblogs.com/nullzx/p/8729425.html
 * m :阶数 一个节点最多有多少子节点 m取2时，就是我们常见的二叉搜索树
 * 每个节点有m-1个关键字
 * 非根结点至少有Math.ceil(m/2)-1个关键字。
 */
//        1.根结点至少有两个子女。
//
//        2.每个中间节点都包含k-1个元素和k个孩子，其中 m/2 <= k <= m
//
//        3.每一个叶子节点都包含k-1个元素，其中 m/2 <= k <= m
//
//        4.所有的叶子结点都位于同一层。
//
//        5.每个节点中的元素从小到大排列，节点当中k-1个元素正好是k个孩子包含的元素的值域分划。
public class Node {
    // 父节点
    private Node parent;

    // 子节点
    private List<Node> children;

    // 节点值
    private List<Integer> values;

    // 是否是根节点
    private boolean isChild;

    public boolean isChild() {
        return isChild;
    }

    public void setChild(boolean child) {
        isChild = child;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        //list.add(5);
       // System.out.println(list.get(4/2));
       // list.subList(4/2+1,4).forEach(System.out::println);
       // System.out.println(4/2+1);
        list.remove(0);
        list.add(0, 9);
        list.add(1, 8);
        list.forEach(System.out::println);
    }
}
