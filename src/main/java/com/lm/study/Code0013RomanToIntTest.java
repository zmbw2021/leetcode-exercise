package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode-0013 罗马数字转整数
 * 给定一个罗马数字，将其转换成整数
 *
 * level 2
 * @author limin
 * @date 2021/2/21
 */
public class Code0013RomanToIntTest {
    public int romanToInt(String s) {
        int result = 0, preNum = getValue(s.charAt(0)), curNum;
        for (int i = 1; i < s.length(); i++) {
            curNum = getValue(s.charAt(i));
            if (preNum < curNum) {
                result -= preNum;
            } else {
                result += preNum;
            }
            preNum = curNum;
        }
        return result + preNum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    @Test
    public void test() {
        Code0013RomanToIntTest romanToIntTest = new Code0013RomanToIntTest();
        Assert.assertEquals(3, romanToIntTest.romanToInt("III"));
        Assert.assertEquals(4, romanToIntTest.romanToInt("IV"));
        Assert.assertEquals(9, romanToIntTest.romanToInt("IX"));
        Assert.assertEquals(58, romanToIntTest.romanToInt("LVIII"));
        Assert.assertEquals(1994, romanToIntTest.romanToInt("MCMXCIV"));
    }
}
