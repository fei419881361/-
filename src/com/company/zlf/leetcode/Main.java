package com.company.zlf.leetcode;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//
//import java.util.ArrayList;
//import java.util.List;
//
public class Main {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(2020,11,31);
        Date test = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");
        System.out.println(sdf.format(test));
    }
}
//
////输入：n = 3
////        输出：[
////        "((()))",
////        "(()())",
////        "(())()",
////        "()(())",
////        "()()()"
////        ]
//
//class Solution {
//    private static int len;
//    StringBuilder buf;
//    List<String> result = new ArrayList<>();
//
//    public List<String> generateParenthesis(int n) {
//        len = n;
//        buf = new StringBuilder();
//        create(n,n,buf);
//        return result;
//    }
//
//    private void create(int left, int right, StringBuilder buf) {
//        if (left == 0 && right == 0) {
//            result.add(buf.toString());
//        }
//        if (left > 0) {
//            buf.append('(');
//            int bufLen = buf.length()-1;
//            create(left - 1, right, buf);
//            // 回溯
//            buf.delete(bufLen, buf.length());
//        }
//        if (right > left) {
//            buf.append(')');
//            create(left, right - 1,buf);
//        }
//    }
//
//
//    public static void main(String[] args) {
//        new Solution().generateParenthesis(3).forEach(System.out::println);
//    }
//}
