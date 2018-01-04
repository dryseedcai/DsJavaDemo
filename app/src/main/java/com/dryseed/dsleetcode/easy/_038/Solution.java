package com.dryseed.dsleetcode.easy._038;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/05/03
 *     desc  :
 * </pre>
 */
public class Solution {
    public String countAndSay(int n) {
        String str = "1";
        while (n > 1) {
            StringBuffer sb = new StringBuffer();
            char[] chars = str.toCharArray();
            int length = chars.length;
            int times = 1;
            for (int i = 1; i < length; i++) {
                if (chars[i - 1] == chars[i]) {
                    times++;
                } else {
                    sb.append(times).append(chars[i - 1]);
                }
            }
            str = sb.append(times).append(chars[length - 1]).toString();
            n--;
        }

        return str;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i < 8; i++) {
            System.out.println(solution.countAndSay(i));
        }
    }
}
