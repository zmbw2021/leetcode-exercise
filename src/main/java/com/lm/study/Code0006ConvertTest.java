package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode--0006 Z字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * level 2 98.18%
 * @author limin
 * @date 2021/2/21
 */
public class Code0006ConvertTest {
    public String convert(String s, int numRows) {
        return "";
    }

    @Test
    public void test() {
        Code0006ConvertTest convertTest = new Code0006ConvertTest();
        Assert.assertEquals("PAHNAPLSIIGYIR", convertTest.convert("PAYPALISHIRING", 3));
        Assert.assertEquals("PINALSIGYAHRPI", convertTest.convert("PAYPALISHIRING", 4));
        Assert.assertEquals("A", convertTest.convert("A", 1));
    }
}
