package com.company.zlf.leetcode;

public class leetcode112 {
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum = sum - root.val;
        // 如果是叶子是否满足要求
        if (root.left == null && root.right == null) {
            return (sum == 0);
        }
        // 递归查找
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}