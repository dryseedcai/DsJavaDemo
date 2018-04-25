package com.dryseed.javademo.algorithm.integer;

public class P02 {
    public void print_1(int n) {
        StringBuffer start = new StringBuffer(); // 最小的n位数
        StringBuffer end = new StringBuffer(); // 最大的n位数
        for (int i = 0; i < n; i++) {
            start.append("0");
            end.append("9");
        }

        // 循环打印从1到最大的n位十进制数
        while (!start.toString().equals(end.toString())) { // StringBuilder没有重写Object的equals方法
            int index = n - 1;
            while (Integer.valueOf(start.charAt(index) - 48) == 9) { //从后向前扫描，使index指向第一个不为9的数字
                index--;
            }
            if (index == n - 1) {
                // 正常累加
                start = start.replace(
                        index,
                        index + 1,
                        String.valueOf(start.charAt(index) - 48 + 1)
                );
            } else {
                // 进位处理
                StringBuilder rp = new StringBuilder(String.valueOf(start.charAt(index) - 48 + 1));
                int temp = index;
                while (temp < n - 1) {
                    temp++;
                    rp.append("0");
                }
                start = start.replace(index, n, rp.toString());
            }
            System.out.println(trim(start));
        }
    }

    //==============================================================================================

    /**
     * 在递归的临界点解决问题，用于保存结果  (@author: rico)
     */
    static StringBuffer result = new StringBuffer();

    /**
     * 递归
     *
     * @param n
     * @description 递归打印从1到99...9
     */
    public static void print_2(int n) {
        if (n == 0) {   // 递归终止条件
            // 简单情景下的处理
            String s = trim(result);   //去除数字前面的0
            if (!s.equals("")) {
                System.out.println(s);
            }
        } else {
            for (int i = 0; i < 10; i++) {
                result.append(i);  // 递去
                print_2(n - 1);    // 提取重复的逻辑，缩小问题规模
                result = result.deleteCharAt(result.length() - 1);  // 归来
            }
        }
    }


    /**
     * @param sb
     * @return
     * @description 去掉前面的0
     */
    public static String trim(StringBuffer sb) {
        int index = 0;
        while (index < sb.length() && sb.charAt(index) == '0') {
            index++;
        }
        return sb.substring(index);
    }

    public static void main(String[] args) {
        //new P02().print_1(3);
        new P02().print_2(3);
    }
}
