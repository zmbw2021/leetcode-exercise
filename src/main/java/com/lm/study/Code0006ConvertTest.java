package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode--0006 Z字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * @author limin
 * @date 2021/2/21
 */
public class Code0006ConvertTest {
    public String convert(String s, int numRows) {
        if (s == null || s.length() <= 1 || numRows <= 1 || s.length() <= numRows) {
            return s;
        }
        int divided = 2 * numRows - 2;
        int divNums = s.length() / divided;
        if (s.length() % divided != 0) {
            divNums++;
        }
        int numCols = divNums * (numRows - 1);
        char[][] res = new char[numRows][numCols];
        int index = 0;
        int x = 0;
        int y = 0;
        while (index < s.length()) {
            if (index % divided < numRows - 1) {
                res[x++][y] = s.charAt(index++);
            } else {
                res[x--][y++] = s.charAt(index++);
            }
        }
        return processArr2String(res);
    }

    private String processArr2String(char[][] arr) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }
                res.append(arr[i][j]);
            }
        }
        return res.toString();
    }

    @Test
    public void test() {
        Code0006ConvertTest convertTest = new Code0006ConvertTest();
        Assert.assertEquals("PAHNAPLSIIGYIR", convertTest.convert("PAYPALISHIRING", 3));
        Assert.assertEquals("PINALSIGYAHRPI", convertTest.convert("PAYPALISHIRING", 4));
        Assert.assertEquals("A", convertTest.convert("A", 1));
    }
}
