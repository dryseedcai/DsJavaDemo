package com.dryseed.dsleetcode.easy._053;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/05/04
 *     desc  :
 * </pre>
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length, dp = nums[0], max = dp;
        for (int i = 1; i < len; ++i) {
            dp = nums[i] + (dp > 0 ? dp : 0);
            if (dp > max) max = dp;
        }
        return max;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums0 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(nums0));
    }
}
