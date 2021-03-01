package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode--0009 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 *
 * level 2 99.13%
 * @author limin
 * @date 2021/2/21
 */
public class Code0009IsPalindromeTest {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int result = 0;
        while (result < x) {
            result = 10 * result + x % 10;
            x /= 10;
        }
        return result == x || result / 10 == x;
    }

    @Test
    public void test() {
        Code0009IsPalindromeTest isPalindromeTest = new Code0009IsPalindromeTest();
        Assert.assertTrue(isPalindromeTest.isPalindrome(121));
        Assert.assertFalse(isPalindromeTest.isPalindrome(-121));
        Assert.assertFalse(isPalindromeTest.isPalindrome(10));
        Assert.assertFalse(isPalindromeTest.isPalindrome(-101));
        Assert.assertFalse(isPalindromeTest.isPalindrome(21120));
    }
}
