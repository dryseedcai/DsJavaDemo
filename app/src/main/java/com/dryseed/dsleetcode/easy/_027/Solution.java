package com.dryseed.dsleetcode.easy._027;

/**
 * Created by caiminming on 2017/12/21.
 */

public class Solution {

    private int removeElement(int[] nums, int val) {
        int tail = 1;
        int size = nums.length;
        for (int i = 1; i < size; i++) {
            if (nums[i] != val) {
                nums[tail++] = nums[i];
            }
        }
        return tail;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = new int[]{0, 3, 1, 1, 2, 3, 3, 3};
        int len = solution.removeElement(data, 3);
        for (int i = 0; i < len; i++) {
            System.out.print(data[i] + (i == len - 1 ? "" : ", "));
        }
    }


}
