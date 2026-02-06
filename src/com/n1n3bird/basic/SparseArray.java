package com.n1n3bird.basic;

public class SparseArray {
    public static void main(String[] args) {

        int[][] chessArr1 = new int[8][8];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;

        System.out.println("原始的二维数组~~");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // 将二维数组 转 稀疏数组
        // 遍历二维数组 得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }

        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = 8;
        sparseArr[0][1] = 8;
        sparseArr[0][2] = sum;

        // 遍历二维数组，将非0的值存放到 sparseArr中
        int count = 0; //count 用于记录是第几个非0数据
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        System.out.println();
        System.out.println("得到的稀疏数组为~~");
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        // 还原
        // 读取l1
        int[][] newChessArr = new int[sparseArr[0][0]][sparseArr[0][1]];

        // 读取all
        for (int i = 1; i <= sum; i++) {
            int row = sparseArr[i][0];
            int col = sparseArr[i][1];
            int value = sparseArr[i][2];
            newChessArr[row][col] = value;
        }

        // 还原
        System.out.println();
        System.out.println("还原后的二维数组~~");
        for (int[] row : newChessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
