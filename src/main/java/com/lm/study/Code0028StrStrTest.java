package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode-0028 实现strStr()
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回 -1
 *
 * level 1 100.00%
 * @author limin
 * @date 2021/2/21
 */
public class Code0028StrStrTest {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() < 1) {
            return 0;
        }
        if (haystack == null) {
            return -1;
        }
        int i = 0;
        while (i <= haystack.length() - needle.length()) {
            if (haystack.charAt(i) == needle.charAt(0) && haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Test
    public void test() {
        Code0028StrStrTest strStrTest = new Code0028StrStrTest();
        Assert.assertEquals(2, strStrTest.strStr("hello", "ll"));
        Assert.assertEquals(-1, strStrTest.strStr("aaaaa", "bba"));
    }
}
