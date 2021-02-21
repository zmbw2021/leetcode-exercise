package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode--0005 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * @author limin
 * @date 2021/2/21
 */
public class Code0005LongestPalindromeTest {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = start + 1;
        int maxLength = 0;
        String result = "";
        while (start + maxLength < s.length()) {
            if (isPalindrome(s.substring(start, end)) && (maxLength < end - start)) {
                maxLength = end - start;
                result = s.substring(start, end);
            }
            if (end == s.length()) {
                start++;
                end = start + 1;
            } else {
                end++;
            }
        }
        return result;
    }

    private boolean isPalindrome(String target) {
        int start = 0;
        int end = target.length() - 1;
        while (start < end) {
            if (target.charAt(start) != target.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    @Test
    public void test() {
        Code0005LongestPalindromeTest longestPalindromeTest = new Code0005LongestPalindromeTest();
        Assert.assertEquals("bab", longestPalindromeTest.longestPalindrome("babad"));
        Assert.assertEquals("bb", longestPalindromeTest.longestPalindrome("cbbd"));
        Assert.assertEquals("a", longestPalindromeTest.longestPalindrome("a"));
    }
}
