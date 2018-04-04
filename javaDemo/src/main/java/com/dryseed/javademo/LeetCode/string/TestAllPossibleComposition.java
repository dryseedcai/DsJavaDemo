package com.dryseed.javademo.LeetCode.string;

/**
 * 输入一个字符串，打印出该字符串的所有排列
 * <p>
 * log:
 *   abc
 *   acb
 *   bac
 *   bca
 *   cba
 *   cab
 */
public class TestAllPossibleComposition {
    public static void main(String args[]) {
        printAllPossibleComposition("abc".toCharArray(), 0);
    }

    private static void printAllPossibleComposition(char[] chars, int depth) {
        if (depth >= chars.length - 1) {
            System.out.println(chars);
            return;
        }

        for (int i = depth; i < chars.length; i++) {
            swap(chars, depth, i);
            printAllPossibleComposition(chars, depth + 1);
            swap(chars, depth, i); //复原
        }

    }

    private static void swap(char[] chars, int p, int q) {
        char temp = chars[p];
        chars[p] = chars[q];
        chars[q] = temp;
    }
}
