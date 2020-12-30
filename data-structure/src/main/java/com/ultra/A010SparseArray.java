package com.ultra;

import org.junit.Test;

import java.util.Arrays;

/**
 * 二维数组转稀疏数组
 * 稀疏数组转二维数组
 *
 * @author fan
 */
public class A010SparseArray {
    /**
     * (一)原始而二维数组
     * 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 1 0 0 0 0 0 0 0 0
     * 0 0 0 2 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0
     * (二)抽象成稀疏数组
     * 1) 11行 11列 2个值
     * 2) [1][2]值为 1,[2][3]值为 2
     * 11 11 2
     * 1  2  1
     * 2  3  2
     * (三)还原成二维数组
     */
    @Test
    public void testSparse() {
        int[][] array = new int[11][11];
        array[1][2] = 1;
        array[2][3] = 2;
        int[][] sparse = arrayToSparse(array);
        System.out.println(Arrays.deepToString(sparse));
        array = sparseToArray(sparse);
        System.out.println(Arrays.deepToString(array));
    }

    /**
     * 二维数组转稀疏数组
     *
     * @param array 二维数组
     * @return 稀疏数组
     */
    private int[][] arrayToSparse(int[][] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        int sum = 0;
        int length = array.length;
        int secondLength = array[0].length;
        for (int[] ints : array) {
            for (int j = 0; j < secondLength; j++) {
                if (ints[j] != 0) {
                    sum++;
                }
            }
        }
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = length;
        sparseArray[0][1] = secondLength;
        sparseArray[0][2] = sum;
        int row = 1;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < secondLength; j++) {
                if (array[i][j] != 0) {
                    sparseArray[row][0] = i;
                    sparseArray[row][1] = j;
                    sparseArray[row][2] = array[i][j];
                    row++;
                }
            }
        }
        return sparseArray;
    }

    /**
     * 稀疏数组转二维数组
     *
     * @param sparse 稀疏数组
     * @return 二维数组
     */
    private int[][] sparseToArray(int[][] sparse) {
        if (sparse == null || sparse.length == 0) {
            return null;
        }
        int[][] array = new int[sparse[0][0]][sparse[0][1]];
        int sum = sparse[0][2];
        for (int i = 1; i < sum + 1; i++) {
            int length = sparse[i][0];
            int with = sparse[i][1];
            int value = sparse[i][2];
            array[length][with] = value;
        }
        return array;
    }
}
