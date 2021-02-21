package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode-0014 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀
 *
 * @author limin
 * @date 2021/2/21
 */
public class Code0014LongestCommonPrefixTest {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return new String();
        }
        int row = strs.length;
        int col = 0;
        for (int i = 0; i < strs.length; i++) {
            if (col < strs[i].length()) {
                col = strs[i].length();
            }
        }
        char[][] target = new char[row][col];
        for (int i = 0; i < strs.length; i++) {
            char[] tmp = strs[i].toCharArray();
            for (int j = 0; j < tmp.length; j++) {
                target[i][j] = tmp[j];
            }
        }

        // 纵向比较每个字符串的开头
        StringBuilder res = new StringBuilder();
        for (int j = 0; j < col; j++) {
            char tmp = target[0][j];
            for (int i = 1; i < row; i++) {
                if (tmp != target[i][j]) {
                    return res.toString();
                }
            }
            res.append(tmp);
        }
        return res.toString();
    }

    @Test
    public void test() {
        Code0014LongestCommonPrefixTest longestCommonPrefixTest = new Code0014LongestCommonPrefixTest();
        Assert.assertEquals("fl", longestCommonPrefixTest.longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
        Assert.assertEquals("", longestCommonPrefixTest.longestCommonPrefix(new String[] {"dog", "racecar", "car"}));
    }
}
