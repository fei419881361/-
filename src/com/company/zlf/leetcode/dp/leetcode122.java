package com.company.zlf.leetcode.dp;

/**
 * @author zhanglf
 * @Date 2020/12/29 下午11:19
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode122 {
}
class Solution122 {
    int max = 0;
    public int maxProfit(int[] prices) {
        int n = prices.length;

        // dp[i][0] 第i天 手里没有股票 ： 前一天就没有， 当天卖了
        // dp[i][1] 第i天 手里有股票 ： 前一天没有当天买了，  以一天有，当天没卖

        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
           // 当天没有股票         前一天就没有        前一天有 当天卖了
            dp[i][0] = Math.max(dp[i - 1][0], dp[i-1][1] + prices[i]);
            // 当天有股票           前一天就有        前一天没有， 当天买
            dp[i][1] = Math.max(dp[i - 1][1], dp[i-1][0] - prices[i]);
        }
        // 最后一天 手里肯定没有股票 才赚钱。
        return dp[n - 1][0];
    }

}