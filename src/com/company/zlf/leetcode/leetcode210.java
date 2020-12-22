package com.company.zlf.leetcode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode210 {
}
//输入: 4, [[1,0],[2,0],[3,1],[3,2]]
//        输出: [0,1,2,3] or [0,2,1,3]
//        解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
//             因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
//

class Solution10 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        // 每门课的入度
        int[] du = new int[numCourses];
        // 存储入度为0的队列
        Queue<Integer> queue = new LinkedList<>();
        // 计算每门课的入度
        for (int i = 0; i < prerequisites.length; i++) {
            du[prerequisites[i][0]] ++;
        }
        // 找到入度为0的课程，并加入到队列中
        for (int i = 0; i < du.length; i++) {
            if (du[i] == 0) {
                queue.offer(i);
            }
        }
        // 返回结果数组的下标值
        int index = 0;
        // 将入度为0的课程加入到结果数组中
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[index++] = node;
            for (int[] temp : prerequisites) {
                // 将当前入度为0的课程的关联课程的入度减1
                if (temp[1] == node) {
                    du[temp[0]] --;
                    // 继续判断当前课程入度是否变成了0
                    if (du[temp[0]] == 0) {
                        queue.offer(temp[0]);
                    }
                }
            }
        }
        // 如果返回的结果下标和课程数量不一致就返回空数组
        return index != numCourses ? new int[0] : result;
    }

    public static void main(String[] args) {
        int[][] a = new int[1][2];
        a[0] = new int[]{1,0};
        new Solution10().findOrder(2,a) ;
    }
}