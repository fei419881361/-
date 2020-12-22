package com.company.zlf.btree2;

public class BNode {
    static int t; // 确定树的顺序
    int count; // 节点keys的数量
    int[] key; // key 的数组
    BNode[] child; // 子节点
    boolean leaf; //是不是叶子节点
    BNode parent; //当前节点的父节点

    public BNode() {
    }

    public BNode(int t, BNode parent) {
        this.t = t;  //assign size // n >= 2

        this.parent = parent; //assign parent

        key = new int[2*t - 1];  // array of proper size

        child = new BNode[2*t]; // array of refs proper size

        leaf = true; // everynode is leaf at first;

        count = 0; //until we add keys later.

    }

    // -----------------------------------------------------
// this is method to return key value at index position|
// -----------------------------------------------------

    public int getValue(int index)
    {
        return key[index];
    }

// ----------------------------------------------------
// this is method to get ith child of node            |
// ----------------------------------------------------

    public BNode getChild(int index)
    {
        return child[index];
    }
}
