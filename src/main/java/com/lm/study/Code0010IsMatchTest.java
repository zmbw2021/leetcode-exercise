package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode-0010 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * level 3 80.25%
 * @author limin
 * @date 2021/2/21
 */
public class Code0010IsMatchTest {
    /**
     * 动态规划
     * */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    @Test
    public void test() {
        Code0010IsMatchTest isMatchTest = new Code0010IsMatchTest();
        Assert.assertFalse(isMatchTest.isMatch("aa", "a"));
        Assert.assertTrue(isMatchTest.isMatch("aa", "a*"));
        Assert.assertTrue(isMatchTest.isMatch("ab", ".*"));
        Assert.assertTrue(isMatchTest.isMatch("aab", "c*a*b"));
        Assert.assertFalse(isMatchTest.isMatch("mississippi", "mis*is*p*."));
    }
}
