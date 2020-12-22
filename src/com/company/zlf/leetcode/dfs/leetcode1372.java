package com.company.zlf.leetcode.dfs;




import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author zhanglf
 * @Date 2020/12/21 下午9:35
 */
public class leetcode1372 {
}
//给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
//
//        选择二叉树中 任意 节点和一个方向（左或者右）。
//        如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
//        改变前进方向：左变右或者右变左。
//        重复第二步和第三步，直到你在树中无法继续移动。
//        交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
//
//        请你返回给定树中最长 交错路径 的长度。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/longest-zigzag-path-in-a-binary-tree
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
/**
 * 方法一：动态规划
 * f(u)是根节点到u节点，以u节点为u父亲左儿子的最长交错路径。
 * g(u)是根节点到u节点，以u节点为u父亲右儿子的最长交错路径。
 *
 * f(u) = g(father(u)) + 1 //u是左儿子
 * g(u) = f(fatger(u)) +1 //u是右儿子
 *
 *
 * 方法二：构建resultType
 * 当前点的最长交错路径 = max(左儿子最长叫做路径, 右儿子最长交错路径)
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//class Solution1372 {
//    Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
//    Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();
//    Queue<TreeNode[]> q = new LinkedList<TreeNode[]>();
//
//    public int longestZigZag(TreeNode root) {
//        dp(root);
//        int maxAns = 0;
//        for (TreeNode u : f.keySet()) {
//            maxAns = Math.max(maxAns, Math.max(f.get(u), g.get(u)));
//        }
//        return maxAns;
//    }
//
//    /**
//     * 这里提供一个 BFS 的版本。我们用二元组 (node, parent) 作为状态，
//     * 其中 node 表示当前待计算 f 和 g 的值的节点，parent 表示它的父亲。
//     *
//     * @param o root节点
//     */
//    public void dp(TreeNode o) {
//        f.put(o, 0);
//        g.put(o, 0);
//        q.offer(new TreeNode[]{o, null});
//        while (!q.isEmpty()) {
//            TreeNode[] y = q.poll();
//            TreeNode u = y[0], x = y[1];
//            f.put(u, 0);
//            g.put(u, 0);
//            if (x != null) {
//                // 判断是父亲的左儿子还是右儿子
//                // 使用到动态规划方程了！
//                if (x.left == u) {
//                    f.put(u, g.get(x) + 1);
//                }
//                if (x.right == u) {
//                    g.put(u, f.get(x) + 1);
//                }
//            }
//            if (u.left != null) {
//                q.offer(new TreeNode[]{u.left, u});
//            }
//            if (u.right != null) {
//                q.offer(new TreeNode[]{u.right, u});
//            }
//        }
//    }
//
//}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
 }
class Solution1372 {
    Integer res = 0;
    public int longestZigZag(TreeNode root) {

        helper(root);
        return this.res;
    }

    public Pair helper(TreeNode o) {
        if (o == null) {
            return new Pair(-1, -1);
        }
        Pair left = helper(o.left);
        Pair right = helper(o.right);

        Pair current = new Pair(left.second + 1, right.first + 1);
        res = Math.max(res, Math.max(current.first, current.second));

        return current;
    }
    public int[] dfs(TreeNode node){
        if(node == null){
            return new int[]{0,0};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int[] current = new int[]{1+left[1], 1+right[0]};
        this.res = Math.max(res, Math.max(current[0], current[1]));
        return current;
    }

    class Pair{
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
        public int first;
        public int second;
    }
}
