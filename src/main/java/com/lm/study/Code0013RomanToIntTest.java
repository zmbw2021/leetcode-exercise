package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

enum EnumRomanNum {
    I('I', 1),
    V('V', 5),
    X('X', 10),
    L('L', 50),
    C('C', 100),
    D('D', 500),
    M('M', 1000);

    private final char name;
    private final int value;

    EnumRomanNum(char name, int value) {
        this.name = name;
        this.value = value;
    }

    public static int getValue(char name) {
        EnumRomanNum[] values = EnumRomanNum.values();
        for (int i = 0; i < values.length; i++) {
            if (values[i].name == name) {
                return values[i].value;
            }
        }
        return -1;
    }
}

/**
 * leetcode-0013 罗马数字转整数
 * 给定一个罗马数字，将其转换成整数
 *
 * @author limin
 * @date 2021/2/21
 */
public class Code0013RomanToIntTest {
    public int romanToInt(String s) {
        if (s == null) {
            return 0;
        }
        int res = 0;
        if (s.contains("IV")) {
            res += 4;
            s = s.replace("IV", "");
        }
        if (s.contains("IX")) {
            res += 9;
            s = s.replace("IX", "");
        }
        if (s.contains("XL")) {
            res += 40;
            s = s.replace("XL", "");
        }
        if (s.contains("XC")) {
            res += 90;
            s = s.replace("XC", "");
        }
        if (s.contains("CD")) {
            res += 400;
            s = s.replace("CD", "");
        }
        if (s.contains("CM")) {
            res += 900;
            s = s.replace("CM", "");
        }

        List<Character> characterArrayList = new ArrayList();
        List<Integer> countList = new ArrayList();
        char[] romanStr = s.toCharArray();
        if (romanStr.length == 0) {
            return res;
        }
        char cur = romanStr[0];
        int count = 1;
        for (int i = 1; i < romanStr.length; i++) {
            if (cur == romanStr[i]) {
                count++;
            } else {
                characterArrayList.add(cur);
                countList.add(count);
                cur = romanStr[i];
                count = 1;
            }
        }
        characterArrayList.add(cur);
        countList.add(count);

        for (int i = 0; i < characterArrayList.size(); i++) {
            int value = EnumRomanNum.getValue(characterArrayList.get(i));
            res += value * countList.get(i);
        }
        return res;
    }

    @Test
    public void test() {
        Code0013RomanToIntTest romanToIntTest = new Code0013RomanToIntTest();
        Assert.assertEquals(3, romanToIntTest.romanToInt("III"));
        Assert.assertEquals(4, romanToIntTest.romanToInt("IV"));
        Assert.assertEquals(9, romanToIntTest.romanToInt("IX"));
        Assert.assertEquals(58, romanToIntTest.romanToInt("LVIII"));
        Assert.assertEquals(1994, romanToIntTest.romanToInt("MCMXCIV"));
    }
}
