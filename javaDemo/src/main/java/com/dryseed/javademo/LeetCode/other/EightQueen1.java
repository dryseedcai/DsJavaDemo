package com.dryseed.javademo.LeetCode.other;

/*
    http://baidu.iqiyi.com/watch/5634219100363429267.html?page=videoMultiNeed
    8皇后问题：有92个答案

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
public class EightQueen1 {
    private static int COLUMNS = 8;

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

        method1(datas);
    }

    /**
     * 先把8个皇后放在棋盘上，再判断是否符合条件
     *
     * @param datas
     */
    private static void method1(int[][] datas) {
        int count = 0;
        int row1, row2, row3, row4, row5, row6, row7, row8;
        for (row1 = 0; row1 < COLUMNS; row1++) {
            for (row1 = 0; row1 < COLUMNS; row1++) {
                for (row2 = 0; row2 < COLUMNS; row2++) {
                    for (row3 = 0; row3 < COLUMNS; row3++) {
                        for (row4 = 0; row4 < COLUMNS; row4++) {
                            for (row5 = 0; row5 < COLUMNS; row5++) {
                                for (row6 = 0; row6 < COLUMNS; row6++) {
                                    for (row7 = 0; row7 < COLUMNS; row7++) {
                                        for (row8 = 0; row8 < COLUMNS; row8++) {
                                            //充值棋盘标记位
                                            reset(datas);

                                            datas[0][row1] = 2; //第0行第row1列
                                            setUnavailable(datas, 0, row1);

                                            if (datas[1][row2] != 0) {
                                                continue;
                                            }
                                            datas[1][row2] = 2;
                                            setUnavailable(datas, 1, row2);

                                            if (datas[2][row3] != 0) {
                                                continue;
                                            }
                                            datas[2][row3] = 2;
                                            setUnavailable(datas, 2, row3);

                                            if (datas[3][row4] != 0) {
                                                continue;
                                            }
                                            datas[3][row4] = 2;
                                            setUnavailable(datas, 3, row4);

                                            if (datas[4][row5] != 0) {
                                                continue;
                                            }
                                            datas[4][row5] = 2;
                                            setUnavailable(datas, 4, row5);

                                            if (datas[5][row6] != 0) {
                                                continue;
                                            }
                                            datas[5][row6] = 2;
                                            setUnavailable(datas, 5, row6);

                                            if (datas[6][row7] != 0) {
                                                continue;
                                            }
                                            datas[6][row7] = 2;
                                            setUnavailable(datas, 6, row7);

                                            if (datas[7][row8] != 0) {
                                                continue;
                                            }
                                            datas[7][row8] = 2;
                                            //setUnavailable(datas, 7, row8);

                                            count++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static void reset(int[][] datas) {
        for (int i = 0; i < datas.length; i++) {
            int length = datas[i].length;
            for (int j = 0; j < length; j++) {
                datas[i][j] = 0;
            }
        }
    }

    private static void setUnavailable(int[][] datas, int x, int y) {
        int i, j;

        //横排
        for (j = 0; j < COLUMNS; j++) {
            if (j != y) datas[x][j] = 1;
        }

        //竖排
        for (i = 0; i < COLUMNS; i++) {
            if (i != x) datas[i][y] = 1;
        }

        //正斜线
        for (i = 1; x - i >= 0 && y - i >= 0; i++) {
            datas[x - i][y - i] = 1;
        }
        for (i = 1; x + i < COLUMNS && y + i < COLUMNS; i++) {
            datas[x + i][y + i] = 1;
        }

        //负斜线
        for (i = 1; x - i >= 0 && y + i < COLUMNS; i++) {
            datas[x - i][y + i] = 1;
        }
        for (i = 1; x + i < COLUMNS && y - i >= 0; i++) {
            datas[x + i][y - i] = 1;
        }
    }
}
