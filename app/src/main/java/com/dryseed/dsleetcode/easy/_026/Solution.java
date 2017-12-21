package com.dryseed.dsleetcode.easy._026;

/**
 * Created by caiminming on 2017/12/21.
 */

public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;
        int tail = 1;
        for (int i = 1; i < len; ++i) {
            if (nums[i - 1] != nums[i]) {
                nums[tail++] = nums[i];
            }
        }
        return tail;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = new int[]{0, 1, 1, 2, 3, 3, 3};
        int len = solution.removeDuplicates(data);
        for (int i = 0; i < len; i++) {
            System.out.print(data[i] + (i == len - 1 ? "" : ", "));
        }
    }
}
