package com.company.zlf.leetcode.dp;

/**
 * @author zhanglf
 * @Date 2020/12/21 下午8:36
 */

/**
 * 寻找状态转移方程
 */
//        数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
//
//        每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
//
//        您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。


public class leetcode746 {

}

/**
 * 方法一：站在最终结果的角度上去思考
 * 到达楼梯的顶部，可能是（到达前一个楼梯的最小花费+前一个楼梯的花费），（可能是达到前2个楼梯的最小花费+第前2个楼梯的花费）
 * 动态规划方程：mincost(i) = min(mincost(i-1)+cost(i), mincost(i-2)+cost(i-1))
 * 下标从0开始计数
 * 到达第0级阶梯：mincost(0) = min(mincost(-1)+cost(0), mincost(-2)+cost(-1)) = min(cost(0), 0) = 0
 * 到达第1级阶梯：mincost(1) = min(mincost(0)+cost(1), mincost(-1)+cost(0)) = min(cost(1), cost(0))
 *
 *
 *
 * 方法二：站在当前选择的角度上去思考，选择当前阶梯的最小值
 * 比如当前阶梯的最小值 dp[i] 可能是dp[i-1] + cost[i] 或者 dp[i-2] + cost[i]
 * 最终选择最小值： Math.min(dp[size-2], dp[size-1])
 */
class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
//        int size = cost.length;
//        int[] mincost = new int[size];
//        mincost[0] = 0;
//        mincost[1] = Math.min(cost[0], cost[1]);
//
//        for (int i = 2; i < size; i++) {
//            mincost[i] = Math.min(mincost[i-1]+cost[i], mincost[i-2]+ cost[i-1]);
//        }
//        return mincost[size - 1];
        int size = cost.length;
        int mincost0 = 0;
        int mincost1 = Math.min(cost[0], cost[1]);
        int mincost = 0;
        for (int i = 2; i < size; i++) {
            mincost = Math.min(mincost1+cost[i], mincost0+ cost[i-1]);
            mincost0 = mincost1;
            mincost1 = mincost;
        }
        return mincost;
    }
}