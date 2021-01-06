package com.company.zlf;

import java.util.*;

public class Base {

    public static void main(String[] args) {
        // 计算从1 + 到 N
        Scanner sn = new Scanner(System.in);
        int N = sn.nextInt();
        int kaishi = 1;
        int result = 0;

    }
}

class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public void moveZeroes(int[] nums) {
        int index = 0;
        int zern = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }

//            if (i == nums.length - 1) {
//                if (i != (index-1)) {
//                    zern = i - index + 1;
//                }
//            }

        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];

            int diff = target - nums[i];
            Integer index = map.get(diff);
            if (index == null) {
                map.put(cur, i);
            } else {
                ans = new int[]{index, i};
            }
        }
        return ans;
    }

    public final int N = 9;

    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[N];
        int[] cols = new int[N];
        int[] box = new int[N];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char cur = board[i][j];
                if (cur == '.') {
                    continue;
                }
                int temp = board[i][j] - '0';
                if ((rows[i] >> temp & 1) == 1
                        || (cols[j] >> temp & 1) == 1
                        || (box[(i / 3) * 3 + j / 3] >> temp & 1) == 1) {
                    return false;

                }
                rows[i] = rows[i] | (1 << temp);
                cols[j] = cols[j] | (1 << temp);
                box[(i / 3) * 3 + j / 3] = box[(i / 3) * 3 + j / 3] | (1 << temp);
            }
        }
        return true;
    }

    /**
     * 矩形顺时针旋转90°
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        // 1、沿着左上到右下的线翻转矩阵, 遍历右上角的一部分数据
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 2、沿着从上到下的对称轴翻转一次。
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[j][matrix.length - i - 1];
                matrix[j][matrix.length - i - 1] = temp;
            }
        }
    }


    /**
     * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
     * <p>
     * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
     * <p>
     * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
     *
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        if (nums.length < 3) {
            return -1;
        }
        int ans = -1;
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
        }

        int buf = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum - buf - nums[i] == (sum - nums[i]) / 2 && (sum - nums[i]) % 2 == 0) {
                return i;
            }
            buf += nums[i];
        }
        return ans;
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 你可以假设数组中无重复元素。
     * 二分查找
     *
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len <= 0) {
            return 0;
        }
        return returnIndex(0, len - 1, nums, target);
    }

    // 0 1 2 3
    private int returnIndex(int l, int r, int[] nums, int target) {
        if (r < l) {
            return l;
        }

        int mid = (r - l) / 2 + l; // 中间值的下标

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return returnIndex(mid + 1, r, nums, target);
        } else {
            return returnIndex(l, mid - 1, nums, target);
        }
    }

    /**
     * 给出一个区间的集合，请合并所有重叠的区间。
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        // 按照数组第一个数 升序排列
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        int[] temp = intervals[0];
        result.add(temp);
        for (int i = 1; i < intervals.length; i++) {
            int[] buf = result.get(result.size() - 1);
            // 不重叠
            if (buf[1] < intervals[i][0]) {
                result.add(intervals[i]);
            } else {
                // 重叠
                result.get(result.size() - 1)[1] = Math.max(buf[1], intervals[i][1]);
            }
        }
        int[][] ans = new int[result.size()][2];
        return result.toArray(ans);
    }

    public void rotate2(int[][] matrix) {
        // 沿着左上到右下进行对换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 沿着中间对称轴对换
        // 列
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[j][matrix.length - 1 - i];
                matrix[j][matrix.length - 1 - i] = temp;
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        Set<Integer> rowset = new HashSet<>();
        Set<Integer> colset = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowset.add(i);
                    colset.add(j);
                }
            }
        }

        for (int i : rowset) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }

        for (int j : colset) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.setZeroes(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
       // System.out.println(i);
    }
}
