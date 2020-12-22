package com.company.zlf.leetcode;

/**
 * @author zhanglf
 * @Date 2020/12/21 下午9:28
 */
//        给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
//
//        请返回 nums 的动态和。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/running-sum-of-1d-array
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class leetcode1480 {

}

/**
 * dp[i] = dp[i-1]+nums[i]
 * dp[0] = 0+nums[0]
 * dp[1] = dp[0] + nums[i]
 */
class Solution1480 {
    public int[] runningSum(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size];
        dp[0] = nums[0];
        dp[1] = dp[0] + nums[1];
        for (int i = 2; i < size; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
        return dp;
    }
}