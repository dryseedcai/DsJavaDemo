package com.dryseed.javademo.LeetCode.bit;

/**
 * 找出数组中只出现一次的2个数
 * <p>
 * 首先我们考虑这个问题的一个简单版本：一个数组里除了一个数字之外，其他的数字都出现了两次。请写程序找出这个只出现一次的数字。
 * 这个题目的突破口在哪里？题目为什么要强调有一个数字出现一次，其他的出现两次？我们想到了异或运算的性质：任何一个数字异或它自己都等于0。
 * 也就是说，如果我们从头到尾依次异或数组中的每一个数字，那么最终的结果刚好是那个只出现依次的数字，因为那些出现两次的数字全部在异或中抵消掉了。
 */
public class FindNumsAppearOnce {
    public static void main(String args[]) {
        int[] ints = new int[]{9, 5, 8, 8, 6, 5, 6};
        int num = findNumsAppearOnce(ints);
        System.out.println(num);
    }

    private static int findNumsAppearOnce(int[] ints) {
        int ret = 0;
        for (int i : ints) {
            ret = ret ^ i;
        }
        return ret;
    }

}

