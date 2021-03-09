package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode-0032 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度
 *
 * level 2 100.00%
 * @author limin
 * @date 2021/3/9
 */
public class Code0032LongestValidParenthesesTest {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int maxLength = 0;
        for (int i = 1; i < dp.length; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    // 处理...()
                    dp[i] = 2 + (i - 2 >= 0 ? dp[i - 2] : 0);
                } else if (s.charAt(i - 1) == ')') {
                    // 处理...))
                    if (dp[i - 1] > 0) {
                        // 处理...(...))
                        if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                            // 处理...((...))
                            dp[i] = 2 + dp[i - 1] + (i - dp[i - 1] - 1 - 1 >= 0 ? dp[i - dp[i - 1] - 1 - 1] : 0);
                        }
                    }
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    @Test
    public void test() {
        Code0032LongestValidParenthesesTest longestValidParenthesesTest = new Code0032LongestValidParenthesesTest();
        Assert.assertEquals(2, longestValidParenthesesTest.longestValidParentheses("(()"));
        Assert.assertEquals(4, longestValidParenthesesTest.longestValidParentheses(")()())"));
        Assert.assertEquals(0, longestValidParenthesesTest.longestValidParentheses(""));
    }
}
