package com.dryseed.javademo.LeetCode.string;


/**
 * 一个乱序整数数组，奇数排在前面，偶数排在后面
 */
public class TestClassifyNum {
    public static void main(String args[]) {
        int[] ints = new int[]{1, 5, 6, 8, 9, 2, 0, 3};
        classifyNum(ints);

        for (int i : ints) {
            System.out.print(i + " ");
        }
    }

    private static void classifyNum(int[] ints) {
        int i = 0;
        int j = ints.length - 1;

        while (i <= j) {
            while (i <= j && ints[i] % 2 == 1) {
                i++;
            }
            while (i <= j && ints[j] % 2 == 0) {
                j--;
            }
            if (i <= j) {
                swap(ints, i, j);
                i++;
                j--;
            }
        }
    }

    private static void swap(int[] ints, int i, int j) {
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }
}
