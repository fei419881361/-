package com.company.zlf.btree;

import java.util.Collections;

public class BTree {
    // 阶数
    private int m = 5;
    // 根节点
    private Node root;

    // 插入操作
    public void insert(int value) {
        // 第一个值
        if (root == null) {
            root = new Node();
            root.getValues().add(value);
        } else {
            // 根节点是否是子节点？
            if (root.isChild()) {
                // 是根节点，判断节点是否 == m
                //不等于就直接插入
                // 等于就分裂
            } else {
                // 不是根节点，循环进入子节点，直到是子节点。
                //判断节点是否 == m
                //不等于就直接插入
                // 等于就分裂
            }
        }
    }

    /**
     * 分裂
     * @param index 当节点的下标 从 0 开始计算
     */
    private void split(Node parent, Node current, int index) {
        if (current.getValues().size() < m) {
            return;
        }
        // 新分裂出的节点
        Node newNodeLeft = new Node();
        Node newNodeRight = new Node();
        // 中间值
        Integer buf = current.getValues().get(m / 2);

        // 将左边的分割出去
        newNodeLeft.setValues(current.getValues().subList(0, m / 2));
        // 将右边的分割出去
        newNodeRight.setValues(current.getValues().subList(m / 2 + 1, m));
        // 当前节点的值清空
        current.getValues().clear();

        // 中间的移动到父节点，注意排序！
        parent.getValues().add(buf);
        Collections.sort(parent.getValues());
        // 当前父节点是子节点（只有一个节点的情况）
        if (parent.isChild()) {
            parent.getChildren().add(index, newNodeLeft);
            parent.getChildren().add(index+1, newNodeRight);
            return;
        }
        // 删除当前节点，并向父节点加入新的子节点
        parent.getChildren().remove(index);
        parent.getChildren().add(index, newNodeLeft);
        parent.getChildren().add(index+1, newNodeRight);
    }

}
