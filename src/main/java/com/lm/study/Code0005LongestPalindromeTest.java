package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode--0005 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * level 2 34.91%
 * @author limin
 * @date 2021/2/21
 */
public class Code0005LongestPalindromeTest {
    /**
     * 动态规划
     * */
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {
        Code0005LongestPalindromeTest longestPalindromeTest = new Code0005LongestPalindromeTest();
        Assert.assertEquals("aba", longestPalindromeTest.longestPalindrome("babad"));
        Assert.assertEquals("bb", longestPalindromeTest.longestPalindrome("cbbd"));
        Assert.assertEquals("a", longestPalindromeTest.longestPalindrome("a"));
    }
}
