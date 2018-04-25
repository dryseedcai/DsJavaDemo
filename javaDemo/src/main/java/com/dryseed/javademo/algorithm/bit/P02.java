package com.dryseed.javademo.algorithm.bit;

/**
 * Title:二进制中1的个数
 * Description: 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class P02 {

    /**
     * @description 给定整数二进制中有几个1便循环几次
     * 底层思想：消1法，异或运算
     * 把一个整数减去1之后再和原来的整数做位与运算，得到的结果相当于把原整数的二进制表示中的最右边一个1变成0
     */
    public int NumberOf1_2(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;  // 把一个整数减去1,再将其和原整数做与运算,会把该整数最右边的1变成0
        }
        return count;
    }

    /**
     * 避免负数的死循环，不对原数进行右移操作。而是对比对数进行左移操作。
     *
     * @param n
     * @return
     */
    public int NumberOf1_1(int n) {
        int temp = 1;
        int count = 0;
        while (temp != 0) {    // 循环结束条件，从1左移变成0即完成所有二进制位的扫描和比对
            //若(temp & n) == temp,说明n的二进制在对应位置上为 1
            count = (temp & n) == temp ? ++count : count;
            temp = temp << 1;  // temp 不断向左移
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new P02().NumberOf1_2(-5)); // -5 -> 补码11111011
        System.out.println(new P02().NumberOf1_2(5)); // 5 -> 101

        System.out.println(new P02().NumberOf1_1(-5)); // -5 -> 补码11111011
        System.out.println(new P02().NumberOf1_1(5)); // 5 -> 101
        /*
            Log:
                31
                2
         */
    }
}