package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode-0003 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度
 *
 * level 2
 * @author limin
 * @date 2021/1/31
 */
public class Code0003LengthOfLongestSubstringTest {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int pos, length = 0, result = 0, index = 0, repeated = 0;
        while (index < s.length()) {
            pos = s.indexOf(s.charAt(index), repeated);
            if (pos < index) {
                if (length > result) {
                    result = length;
                }
                if (s.length() - repeated <= result) {
                    return result;
                }
                repeated = pos + 1;
                length = index - repeated;
            }
            length++;
            index++;
        }
        return result < length ? length : result;
    }

    @Test
    public void test() {
        Code0003LengthOfLongestSubstringTest lengthOfLongestSubstringTest = new Code0003LengthOfLongestSubstringTest();
        Assert.assertEquals(4, lengthOfLongestSubstringTest.lengthOfLongestSubstring("dabcabcbb"));
        Assert.assertEquals(1, lengthOfLongestSubstringTest.lengthOfLongestSubstring("bbbbb"));
        Assert.assertEquals(3, lengthOfLongestSubstringTest.lengthOfLongestSubstring("pwwkew"));
        Assert.assertEquals(0, lengthOfLongestSubstringTest.lengthOfLongestSubstring(""));
    }
}
