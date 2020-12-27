package com.company.zlf.leetcode;

import java.util.Stack;

/**
 * @author zhanglf
 * @Date 2020/12/27 下午9:
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 */
public class leetcode316 {
}

class Solution316 {
    /**
     * 当前字符入栈 如果字典序小于 前面入栈的字符，则检查前面的字符后面是否会出现，如果会出现则去除。
     */
    public String removeDuplicateLetters(String s) {
        StringBuffer result = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        boolean[] used = new boolean[26];// 是否出现过
        int[] lastIndex = new int[26];
        // 记录最后出现的下标
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            // 当前值已经出现过了，则不用遍历了。
            if (used[cur - 'a']) {
                continue;
            }
            // 与栈中元素比较 若栈中大于当前元素，并且栈中元素在之后还会在出现，则删除。
            while (!stack.isEmpty()
                    && stack.peek() > cur
                    && lastIndex[stack.peek() - 'a'] > i
            ) {

                used[stack.peek() - 'a'] = false;
                stack.pop();
            }
            // 无误则加入结果集
            stack.add(cur);
            used[cur - 'a'] = true;
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Solution316 leetcode316 = new Solution316();
        String s = leetcode316.removeDuplicateLetters("bcabc");
        System.out.println(s);
    }
}