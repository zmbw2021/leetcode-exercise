package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode-0036 有效的数独
 * 判断一个 9x9 的数独是否有效
 *
 * level 2 95.52%
 * @author limin
 * @date 2021/3/9
 */
public class Code0036IsValidSudokuTest {
    private static int SudokuLength = 9;

    public boolean isValidSudoku(char[][] board) {
        int[][] rol = new int[SudokuLength][SudokuLength + 1];
        int[][] col = new int[SudokuLength][SudokuLength + 1];
        int[][] box = new int[SudokuLength][SudokuLength + 1];
        int num, row;
        for (int i = 0; i < SudokuLength; i++) {
            for (int j = 0; j < SudokuLength; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                num = board[i][j] - '0';
                if (rol[i][num] == 1) {
                    return false;
                }
                if (col[j][num] == 1) {
                    return false;
                }
                row = (i / 3) * 3 + j / 3;
                if (box[row][num] == 1) {
                    return false;
                }
                rol[i][num] = 1;
                col[j][num] = 1;
                box[row][num] = 1;
            }
        }
        return true;
    }

    @Test
    public void test() {
        Code0036IsValidSudokuTest isValidSudokuTest = new Code0036IsValidSudokuTest();
        char[][] target = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        Assert.assertTrue(isValidSudokuTest.isValidSudoku(target));
    }
}
