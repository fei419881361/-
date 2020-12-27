package com.company.zlf.leetcode;

/**
 * @author zhanglf
 * @Date 2020/12/26 下午7:03
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 */
public class leetcode85 {
}
class Solution85 {
    // left[][] 从左边到当前点最大的连续长度
    // 遍历每一个点，以当前点为矩形的右下角，判断矩形的最大面积
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] left = new int[matrix.length][matrix[0].length];
        // 构造left[][] 数组
        for (int i = 0; i < matrix.length; i++) {
            // 初始化连续长度为0
            int lx = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    lx++;
                }else {
                    lx = 0;
                }
                left[i][j] = lx;
            }
        }
        int ans = 0;
        // 从下往上遍历
        for (int y = left.length - 1; y >= 0 ; y--) {
            // 从右到左
            for (int j = left[0].length-1 ;j >=0 ; j--) {
                int c = 1;
                // 每一个点，以该点为右下角，向上遍历，找出能围成矩形的最大值
                int min = 0;
                for (int i = y; i >=0 ; i--) {
                    // 当前最小值
                    if (c != 1) {
                        min = Math.min(min, left[i][j]);
                        if (min == 0) {
                            break;
                        }
                    }else {
                        min = left[i][j];
                    }
                    int res = min * c;
                    ans = Math.max(ans, res);
                    c++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution85 solution85 = new Solution85();
//        atrix = [['1','0','1','0','0'],['1','0','1','1','1'],['1','1','1','1','1'],['1','0','0','1','0']]

        int i = solution85.maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}});
        System.out.println(i);
        
    }
}