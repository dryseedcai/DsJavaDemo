package com.dryseed.dsleetcode.easy._007;

/**
 * Created by caiminming on 2017/12/20.
 */

public class Solution {
    public int reverse(int x) {
        long res = 0;
        for (; x != 0; x = x / 10) {
            res = res * 10 + x % 10;
        }
        return (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) ? 0 : (int) res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(100));
        System.out.println(solution.reverse(1000000003)); //Integer.MAX_VALUE:2147483647
    }
}
