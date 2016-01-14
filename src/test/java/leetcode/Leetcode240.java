package leetcode;
/*
*

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.

*
*
* */


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Leetcode240 {


    @Test
    public void should_get_width_and_height() throws Exception {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        assertThat(getHeight(matrix)).isEqualTo(5);
        assertThat(getWidth(matrix)).isEqualTo(5);

    }

    @Test
    public void tc1() throws Exception {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15, 33},
                {2, 5, 8, 12, 20, 36},
                {3, 6, 9, 16, 22, 39},
                {10, 13, 14, 17, 24, 55},
                {18, 21, 23, 26, 34, 99},
                {19, 22, 130, 140, 150, 999}
        };
        int target = 5;
        assertThat(searchMatrix_M_PLUS_N(matrix, target)).isTrue();
    }

    @Test
    public void tc2() throws Exception {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15, 33},
                {2, 5, 8, 12, 20, 36},
                {3, 6, 9, 16, 22, 39},
                {10, 13, 14, 17, 24, 55},
                {18, 21, 23, 26, 34, 99},
                {19, 22, 130, 140, 150, 999}
        };
        int target = 55312;
        assertThat(searchMatrix_M_PLUS_N(matrix, target)).isFalse();
    }

    @Test
    public void tc3() throws Exception {
        int[][] matrix = new int[][]{
                {1, 1}
        };
        int target = 2;
        assertThat(searchMatrix_M_PLUS_N(matrix, target)).isFalse();
    }

    @Test
    public void tc4() throws Exception {
        int[][] matrix = new int[][]{
                {1}
        };
        int target = 1;
        assertThat(searchMatrix_M_PLUS_N(matrix, target)).isTrue();
    }

    /*
    *
    * 两层循环, M*N, 没什么可说...
    *
    * */
    private boolean searchMatrix_M_TIMES_N(int[][] matrix, int target) {
        int xMax = getWidth(matrix) - 1;
        int yMax = getHeight(matrix) - 1;
        for (int y = 0; y <= yMax; y++) {
            for (int x = 0; x <= xMax; x++) {
                if (matrix[y][x] == target) {
                    return true;
                }
            }
        }
        return false;
    }


    /*
    * 左下角开始找, 如果当前坐标大于目标, 向上走, 如果小于, 向右走
    *
    *
    * */
    private boolean searchMatrix_M_PLUS_N(int[][] matrix, int target) {
        int xMax = matrix[0].length - 1;
        int x = 0, y = matrix.length - 1;
        while (x <= xMax && y >= 0) {
            if (matrix[y][x] == target) {
                return true;
            }
            if (matrix[y][x] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }


    private int getWidth(int[][] matrix) {
        return matrix[0].length;
    }

    private int getHeight(int[][] matrix) {
        return matrix.length;
    }


}
