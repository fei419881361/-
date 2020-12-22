package com.company.zlf.leetcode;

public class leetcode152 {
}

/**
 * 动态规划
 * 找最大值，最小值的动态规划方程
 * 最小值为负数乘一个负数可能变成最大值
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(1);
    }
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], nums[i]), min * nums[i]);
            min = Math.min(Math.min(min * nums[i], nums[i]), temp * nums[i]);
            result = Math.max(max, result) ;
        }
        return result;
    }
}