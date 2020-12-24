package com.company.zlf.leetcode;

import java.util.Arrays;

/**
 * @author zhanglf
 * @Date 2020/12/24 下午10:17
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode135 {
}

/**
 * 规则定义： 设学生 AA 和学生 BB 左右相邻，AA 在 BB 左边；
 * 左规则： 当 ratings_B>ratings_Aratings
 * B
 * ​
 *  >ratings
 * A
 * ​
 *  时，BB 的糖比 AA 的糖数量多。
 * 右规则： 当 ratings_A>ratings_Bratings
 * A
 * ​
 *  >ratings
 * B
 * ​
 *  时，AA 的糖比 BB 的糖数量多。
 * 相邻的学生中，评分高的学生必须获得更多的糖果 等价于 所有学生满足左规则且满足右规则。
 */
class Solution135 {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        // 初始化等于最右边边的值
        int count = left[ratings.length - 1];
        // 必须先更新右边的值
        for(int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) right[i] = right[i + 1] + 1;
        }
        // 取左规则  右规则中最大的值
        for (int i = 0; i < ratings.length; i++) {
            count += Math.max(left[i], right[i]);
        }
         return count;
    }

    public static void main(String[] args) {
        Solution135 solution135 = new Solution135();
        int i = solution135.candy(new int[]{0,1,2,3,2,1});
        System.out.println(i);
    }
}