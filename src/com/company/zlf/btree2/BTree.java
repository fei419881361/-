package com.company.zlf.btree2;

public class BTree {
    static int order; // order of tree

    BNode root;  //every tree has at least a root node

    public BTree(int order) {
        this.order = order;
        root = new BNode(order, null);
    }

    public void insert(BTree t, int key) {

    }
}
