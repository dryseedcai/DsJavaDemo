package com.dryseed.javademo.LeetCode.other;

/*
    http://baidu.iqiyi.com/watch/5634219100363429267.html?page=videoMultiNeed
    https://blog.csdn.net/H_JinXian/article/details/51088752

    8皇后问题：有92个答案
    递归解决：主要是要注意回溯过程中已舍弃的皇后代表的数组元素要置0，以免接下来继续使用深度优先搜索时，使用判断规则isSafety出现判断错误。

    皇后放置位置：
        datas[x][y]  //x:行数；y:列数
    横排：
        datas[x][0] ~ datas[x][7]
        for(j = 0; j<8; j++){
            if(j != y ) datas[x][j] = 1;
        }
    竖排：
        datas[0][y] ~ datas[7][y]
        for(i = 0; i<8; i++){
            if(i != x ) datas[i][y] = 1;
        }
    正斜线：
        datas[x+1][y+1]
        datas[x+2][y+2]
        datas[x-1][y-1]
        datas[x-2][y-2]
        ...............
        for(i = 1; x - i >=0 && y - i >=0; i++){
            datas[x-i][y-i] = 1;
        }
        for(i = 1; x + i < 8 && y + i < 8; i++){
            datas[x+i][y+i] = 1;
        }
    负斜线：
        datas[x+1][y-1]
        datas[x+2][y-2]
        datas[x-1][y+1]
        datas[x-2][y+2]
        ...............
        for(i = 1; x - i >=0 && y + i < 8; i++){
            datas[x-i][y+i] = 1;
        }
        for(i = 1; x + i < 8 && y - i >= 0; i++){
            datas[x+i][y-i] = 1;
        }
 */
public class EightQueen2 {
    private static int COLUMNS = 8;
    private static int count = 0;

    public static void main(String[] args) {
        int[][] datas = new int[COLUMNS][COLUMNS];
        for (int i = 0; i < datas.length; i++) {
            int length = datas[i].length;
            for (int j = 0; j < length; j++) {
                datas[i][j] = 0;
                System.out.print(datas[i][j] + " ");
            }
            System.out.println();
        }

        putQueenAtRow(datas, 0);
    }

    private static void putQueenAtRow(int[][] datas, int row) {
        /**
         * 递归终止判断：如果row==N，则说明已经成功摆放了8个皇后
         * 输出结果，终止递归
         */
        if (row == COLUMNS) {
            count++;

            //打印数组
            System.out.println("第 " + count + " 种解：");
            for (int i = 0; i < COLUMNS; i++) {
                for (int j = 0; j < COLUMNS; j++) {
                    System.out.print(datas[i][j] + "  ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        /**
         * 向这一行的每一个位置尝试排放皇后
         * 然后检测状态，如果安全则继续执行递归函数摆放下一行皇后
         */
        for (int i = 0; i < COLUMNS; i++) {
            if (isSafety(datas, row, i)) {
                datas[row][i] = 1;
                putQueenAtRow(datas, row + 1);
                datas[row][i] = 0;
            }
        }
    }

    private static boolean isSafety(int[][] datas, int x, int y) {
        int i, j;

        //横排
        for (j = 0; j < COLUMNS; j++) {
            if (j != y && datas[x][j] == 1) return false;
        }

        //竖排
        for (i = 0; i < COLUMNS; i++) {
            if (i != x && datas[i][y] == 1) return false;
        }

        //正斜线
        for (i = 1; x - i >= 0 && y - i >= 0; i++) {
            if (datas[x - i][y - i] == 1) return false;
        }
        for (i = 1; x + i < COLUMNS && y + i < COLUMNS; i++) {
            if (datas[x + i][y + i] == 1) return false;
        }

        //负斜线
        for (i = 1; x - i >= 0 && y + i < COLUMNS; i++) {
            if (datas[x - i][y + i] == 1) return false;
        }
        for (i = 1; x + i < COLUMNS && y - i >= 0; i++) {
            if (datas[x + i][y - i] == 1) return false;
        }

        return true;
    }

}
