package com.dryseed.javademo.LeetCode.string;

/**
 * 反转字符串
 */
public class TestWordReverse {
    public static void main(String args[]) {
        String str = "The quick brown fox jumps over a lazy dog";
        String reverseStr = wordReverse(str);
        System.out.println(reverseStr);
    }

    private static String wordReverse(String str) {
        StringBuffer sb = new StringBuffer();
        char[] chars = str.toCharArray();
        int size = chars.length;
        for (int i = size - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
