package com.dryseed.javademo.algorithm.bit;

/**
 * Title: 将A-Z表示的26进制转换成10进制数(A在26进制表示1)
 * Description: 在Excel2003中，A表示第1列，B表示第2列...Z表示第26列，
 * AA表示第27列，AB表示第28列...以此类推。给定一个用字母表示的列号编码，输出它是第几列。
 *
 * @author rico
 * @created 2017年6月4日 下午5:23:17
 */
public class P01 {

    public static int getColum(String s) {
        if (s != null && s.length() != 0) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                int num = s.charAt(s.length() - i - 1) - 'A' + 1;
                count += num * Math.pow(26, i); //26的i次方
            }
            return count;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(P01.getColum("AA"));     //27
        System.out.println(P01.getColum("AZ"));     //52
        System.out.println(P01.getColum("BA"));     //53
        System.out.println(P01.getColum("AAA"));    //703
    }
}