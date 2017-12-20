package com.dryseed.dsleetcode.easy._009;

/**
 * Created by caiminming on 2017/12/20.
 */

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false; //负数肯定不是回文
        if (x != 0 && x % 10 == 0) return false;
        int reverseX = 0;
        while (x > reverseX) {
            reverseX = reverseX * 10 + x % 10;
            x = x / 10;
        }
        return reverseX == x || reverseX / 10 == x; //x是偶数位 或者 奇数位
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(-1));
        System.out.println(solution.isPalindrome(10010));

        System.out.println(solution.isPalindrome(0));
        System.out.println(solution.isPalindrome(11));
        System.out.println(solution.isPalindrome(111));
        System.out.println(solution.isPalindrome(222222222));
    }
}
