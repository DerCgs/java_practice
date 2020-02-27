package com.dercg.leetcode.code.a053_maxSubArray;

public class main {
    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 示例:
     * <p>
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * 进阶:
     * <p>
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     */
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("-2,1,-3,4,-1,2,1,-5,4---->:" + maxSubArrayOfficialV2(nums));

    }

    public static int maxSubArrayOfficialV1(int[] nums) {
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }

    public static int maxSubArrayOfficialV2(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            }else {
                sum = num;
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
