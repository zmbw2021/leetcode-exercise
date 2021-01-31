package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

/**
 * leetcode-0003 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度
 *
 * @author limin
 * @date 2021/1/31
 */
public class Code0003LengthOfLongestSubstringTest {
    /**
     * 双指针
     * */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int start = 0;
        set.add(chars[start]);
        int end = 1;
        while (end < chars.length) {
            if (set.contains(chars[end])) {
                max = Math.max(max, end - start);
                set.remove(chars[start++]);
            } else {
                set.add(chars[end++]);
            }
        }
        return Math.max(max, end - start);
    }

    @Test
    public void test() {
        Code0003LengthOfLongestSubstringTest lengthOfLongestSubstringTest = new Code0003LengthOfLongestSubstringTest();
        Assert.assertEquals(3, lengthOfLongestSubstringTest.lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1, lengthOfLongestSubstringTest.lengthOfLongestSubstring("bbbbb"));
        Assert.assertEquals(3, lengthOfLongestSubstringTest.lengthOfLongestSubstring("pwwkew"));
        Assert.assertEquals(0, lengthOfLongestSubstringTest.lengthOfLongestSubstring(""));
    }
}
