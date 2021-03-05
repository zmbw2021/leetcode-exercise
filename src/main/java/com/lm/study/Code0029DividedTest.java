package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode-0029 两数相除
 *
 * level 1 100.00%
 * @author limin
 * @date 2021/2/28
 */
public class Code0029DividedTest {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        return dividend / divisor;
    }

    @Test
    public void test() {
        Code0029DividedTest dividedTest = new Code0029DividedTest();
        Assert.assertEquals(3, dividedTest.divide(10, 3));
        Assert.assertEquals(-2, dividedTest.divide(7, -3));
    }
}
