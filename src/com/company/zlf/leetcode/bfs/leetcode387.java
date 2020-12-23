package com.company.zlf.leetcode.bfs;

/**
 * @author zhanglf
 * @Date 2020/12/23 下午9:26
 */

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 */
public class leetcode387 {
}

class Solution387 {
    public int firstUniqChar(String s) {
        int len = s.length();
        int[][] sint = new int[26][2];
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            sint[c-97][0] = sint[c-97][0] + 1;
            sint[c-97][1] = i;

        }
        int min = len + 1;
        for (int i = 0; i < 26; i++) {
            if (sint[i][0] == 1) {
                min = Math.min(min, sint[i][1]);
            }
        }

       return min == (len+1) ? -1 : min;
    }

    public static void main(String[] args) {
        Solution387 solution387 = new Solution387();
        int i = solution387.firstUniqChar("loveleetcode");
        System.out.println(i);
    }
}