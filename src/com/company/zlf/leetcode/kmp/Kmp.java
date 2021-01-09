package com.company.zlf.leetcode.kmp;

import java.util.Arrays;

/**
 * @author zhanglf
 * @Date 2021/1/9 上午9:53
 */
public class Kmp {
    /**
     * 构造s字符串的next数组
     *
     * @param s
     * @return
     */
    public int[] buildNext(String s) {
        /**
         * 记录最长公共前缀后缀长度
         * next[0] = -1
         * next[i] = x ：字符串s的子串s[0..i-1] 最长的公共前缀后缀长度 x
         * 不包括s本身
         */
        int[] next = new int[s.length()];
        next[0] = -1;
        char[] chars = s.toCharArray();
        int j = 0;
        int t = -1;

        while (j < s.length() - 1) {
            if (t < 0 || chars[j] == chars[t]) {
                j++;
                t++;
                next[j] = t;
               // next[j] = (chars[j] == chars[t] ? t : next[t]);
            }else {
                t = next[t];
            }
        }

        return next;

    }

    public int match(String p, String s) {
        int[] next = buildNext(s);
        int m = s.length();
        int n = p.length();
        int i = 0;
        int j = 0;
        while (j < n && i < m) {
            if (j < 0 || s.charAt(j) == p.charAt(i)) {
                i++;
                j++;
            }else {
                j = next[j];
            }
        }
        return i - j;
    }


    public static void main(String[] args) {
        Kmp kmp = new Kmp();
        int[] ret = kmp.buildNext("actgpacy");
        System.out.println(Arrays.toString(ret));
        int r = kmp.match("AAAAAAAG", "AAAAG");
        System.out.println(r);

    }
}

class Solution28 {
    public int[] buildNext(String s) {
        /**
         * 记录最长公共前缀后缀长度
         * next[0] = -1
         * next[i] = x ：字符串s的子串s[0..i-1] 最长的公共前缀后缀长度 x
         * 不包括s本身
         */
        int[] next = new int[s.length()];
        next[0] = -1;
        char[] chars = s.toCharArray();
        int j = 0;
        int t = -1;

        while (j < s.length() - 1) {
            if (t < 0 || chars[j] == chars[t]) {
                j++;
                t++;
                next[j] = t;
                // next[j] = (chars[j] == chars[t] ? t : next[t]);
            }else {
                t = next[t];
            }
        }

        return next;

    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) {
            return 0;
        }

        int[] next = buildNext(needle);
        int m = needle.length();
        int n = haystack.length();
        int i = 0;
        int j = 0;
        while (j < m && i < n) {
            if (j < 0 || needle.charAt(j) == haystack.charAt(i)) {
                if (j == m - 1) {
                    return i - j;
                }
                i++;
                j++;
            }else {
                j = next[j];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        int i = solution28.strStr("", "a");
        System.out.println(i);
    }
}

