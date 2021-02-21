package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode--0009 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 *
 * @author limin
 * @date 2021/2/21
 */
public class Code0009IsPalindromeTest {
    /**
     * 将数字作为字符串进行处理
     * */
    public boolean isPalindrome(int x) {
        String inputNum = String.valueOf(x);
        char[] inputChar = inputNum.toCharArray();
        int i = 0;
        int j = inputChar.length - 1;
        while (i < j) {
            if (inputChar[i] != inputChar[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    @Test
    public void test() {
        Code0009IsPalindromeTest isPalindromeTest = new Code0009IsPalindromeTest();
        Assert.assertTrue(isPalindromeTest.isPalindrome(121));
        Assert.assertFalse(isPalindromeTest.isPalindrome(-121));
        Assert.assertFalse(isPalindromeTest.isPalindrome(10));
        Assert.assertFalse(isPalindromeTest.isPalindrome(-101));
    }
}
