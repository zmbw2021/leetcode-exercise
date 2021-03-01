package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode--0007 整数反转
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 *
 * level 1 100%
 * @author limin
 * @date 2021/2/21
 */
public class Code0007ReverseTest {
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = 10 * result + x % 10;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
            x = x / 10;
        }
        return (int) result;
    }

    @Test
    public void test() {
        Code0007ReverseTest reverseTest = new Code0007ReverseTest();
        Assert.assertEquals(321, reverseTest.reverse(123));
        Assert.assertEquals(-321, reverseTest.reverse(-123));
        Assert.assertEquals(21, reverseTest.reverse(120));
        Assert.assertEquals(0, reverseTest.reverse(0));
    }
}
