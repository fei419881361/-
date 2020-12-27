package com.company.zlf.leetcode;

import java.util.HashMap;

/**
 * @author zhanglf
 * @Date 2020/12/27 下午8:24
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode205 {
}
class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        // 构造一个k-v字典, 双向记录
        HashMap<Character, Character> kv = new HashMap<>();
        HashMap<Character, Character> kv2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character temp = kv.get(s.charAt(i));
            Character temp2 = kv2.get(t.charAt(i));
            // 当前还没被赋值
            if (temp == null && temp2 == null) {
                kv.put(s.charAt(i), t.charAt(i));
                kv2.put(t.charAt(i), s.charAt(i));
            }else {
                if (temp2 == null || temp == null||temp != t.charAt(i) || temp2!=s.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution205 solution205 = new Solution205();
        solution205.isIsomorphic("ab", "aa");
    }
}