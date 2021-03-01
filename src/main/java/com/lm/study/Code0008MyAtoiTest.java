package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode-0008 字符串转换整数
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数
 *
 * level 2 99.51%
 * @author limin
 * @date 2021/2/21
 */
public class Code0008MyAtoiTest {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        int i = 0, res = 0, n = str.length();
        boolean nag = false;
        // 1.跳过前面的空格，如果全是空格直接返回0
        while (i < n && str.charAt(i) == ' ') {
            ++i;
        }
        if (i == n) {
            return 0;
        }
        // 2.判断正负号，如果有正负号，跳过1位
        if (str.charAt(i) == '-') {
            nag = true;
        }
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            ++i;
        }
        // 3.循环判断字符是否在0~9之间
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            int tmp = str.charAt(i) - 48;
            if (!nag && (res > 214748364 || (res == 214748364 && tmp >= 7))) {
                return 2147483647;
            }
            if (nag && (res > 214748364 || (res == 214748364 && tmp >= 8))) {
                return -2147483648;
            }
            res = res * 10 + tmp;
            ++i;
        }
        return nag ? -res : res;
    }

    @Test
    public void test() {
        Code0008MyAtoiTest myAtoiTest = new Code0008MyAtoiTest();
        Assert.assertEquals(42, myAtoiTest.myAtoi("42"));
        Assert.assertEquals(-42, myAtoiTest.myAtoi("  -42"));
        Assert.assertEquals(4193, myAtoiTest.myAtoi("4193 with words"));
        Assert.assertEquals(0, myAtoiTest.myAtoi("words and 987"));
        Assert.assertEquals(-2147483648, myAtoiTest.myAtoi("-91283472332"));
    }
}
