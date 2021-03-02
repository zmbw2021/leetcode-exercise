package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode--0012 整数转罗马数字
 * 给定一个整数，将其转为罗马数字
 *
 * level 2 100.00%
 * @author limin
 * @date 2021/2/21
 */
public class Code0012IntToRomanTest {
    private static int MAX_NUM = 3999;

    /**
     * 贪心
     * */
    public String intToRoman(int num) {
        if (num < 1 || num > MAX_NUM) {
            return null;
        }

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] key = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                str.append(key[i]);
            }
        }
        return str.toString();
    }

    @Test
    public void test() {
        Code0012IntToRomanTest intToRomanTest = new Code0012IntToRomanTest();
        Assert.assertEquals("III", intToRomanTest.intToRoman(3));
        Assert.assertEquals("IV", intToRomanTest.intToRoman(4));
        Assert.assertEquals("IX", intToRomanTest.intToRoman(9));
        Assert.assertEquals("LVIII", intToRomanTest.intToRoman(58));
        Assert.assertEquals("MCMXCIV", intToRomanTest.intToRoman(1994));
    }
}
