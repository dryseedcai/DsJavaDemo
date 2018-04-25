package com.dryseed.javademo.algorithm.integer;

public class P01 {

    public static void main(String[] args) {
        System.out.println(new P01().power_1(2, 3)); // 8
        System.out.println(new P01().power_2(2, 3)); // 8
    }

    /**
     * 常规解法
     * @param base
     * @param exponent
     * @return
     */
    public double power_1(double base, int exponent) {
        if (base == 0) {  // 边界情况
            return 0;
        } else if (exponent == 0) {    // 边界情况
            return 1;
        }

        double result = base;
        int e = Math.abs(exponent);  // e的绝对值
        for (int i = 0; i < e - 1; i++) {
            result *= base;
        }

        // 根据exponent的正负性，决定是否取倒数
        return exponent > 0 ? result : (1 / result);
    }

    /**
     * 求一个数的n次幂,不再逐个相乘,减少相乘的次数(思想:a^b = a^(b/2)*a^(b/2)),递归算法
     *
     * @param base
     * @param exponent
     * @return
     */
    public double power_2(double base, int exponent) {
        if (base == 0) { // 边界情况
            return 0;
        } else if (exponent == 0) { // 边界情况
            return 1;
        }

        int e = Math.abs(exponent);
        double result = getPower(base, e); // 计算base的e次方

        // 根据exponent的正负性，决定是否取倒数
        return exponent > 0 ? result : (1 / result);
    }

    /**
     * @param base     基数
     * @param exponent 指数
     * @return
     * @description 求一个数的n次幂, 不再逐个相乘, 减少相乘的次数(思想 : a ^ b = a ^ ( b / 2)*a^(b/2)),递归算法
     * @author rico
     * @created 2017年6月5日 下午6:01:32
     */
    private double getPower(double base, int exponent) {
        // 递归终止条件
        if (exponent == 0) {
            return 1.0;    // 简单情景
        } else if (exponent == 1) {
            return base;    // 简单情景
        }

        // 递归计算base的(exponent/2)幂
        exponent = exponent >> 1;
        double result = getPower(base, exponent);   // 提取重复的逻辑，缩小问题规模
        result *= result;    // 减少相乘次数
        if ((exponent & 1) == 1) {    // 判断一个数是否是奇数，奇数的话，再余外乘一次('=='优先级高于'&')
            result *= base;
        }

        return result;
    }
}
