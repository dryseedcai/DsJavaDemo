package com.dryseed.javademo.algorithm.other;

/**
 * Title: 跳台阶
 * Description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class P02 {
    public static void main(String[] args) {
        System.out.println(new P02().JumpFloor(10));
        System.out.println(new P02().JumpFloor2(10));
    }

    /**
     * 递归进行，效率低，有重复计算（不建议）
     *
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if (target < 1) return 0;

        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        }
        // 青蛙跳上一个n级台阶的跳法总数 = 青蛙跳上一个n-1级台阶的跳法总数 + 青蛙跳上一个n-2级台阶的跳法总数
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    /**
     * 优化
     *
     * @param target
     * @return
     */
    public int JumpFloor2(int target) {
        if (target == 1) return 1;
        if (target == 2) return 2;
        int step = 0;
        int stepMinusOne = 2;
        int stepMinusTwo = 1;
        for (int i = 3; i <= target; i++) {
            step = stepMinusOne + stepMinusTwo;
            stepMinusTwo = stepMinusOne;
            stepMinusOne = step;
        }
        return step;
    }
}
