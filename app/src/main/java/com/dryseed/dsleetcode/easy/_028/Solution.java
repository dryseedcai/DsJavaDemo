package com.dryseed.dsleetcode.easy._028;

/**
 * Created by caiminming on 2017/12/21.
 */

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("12345", "23"));
        System.out.println(solution.strStr("12345", ""));
    }

    private int strStr(String haystack, String needle) {
        int l1 = haystack.length();
        int l2 = needle.length();
        if (l1 < l2) return -1;
        if (l2 == 0) return 0;

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
                if (j == l2 - 1) return i;
            }
        }

        return -1;
    }
}
