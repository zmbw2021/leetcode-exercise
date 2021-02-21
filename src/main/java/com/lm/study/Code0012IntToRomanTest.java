package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode--0012 整数转罗马数字
 * 给定一个整数，将其转为罗马数字
 *
 * @author limin
 * @date 2021/2/21
 */
public class Code0012IntToRomanTest {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 3999;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int NINE = 9;

    public String intToRoman(int num) {
        if (num < MIN_VALUE || num > MAX_VALUE) {
            return "";
        }
        int curNum = num;
        int bit = 0;
        List<String> romanList = new ArrayList<>();
        while (curNum != 0) {
            int value = curNum % 10;
            curNum /= 10;
            switch (bit) {
                case 0:
                    transferSingle(romanList, value);
                    break;
                case 1:
                    transferTens(romanList, value);
                    break;
                case 2:
                    transferHundreds(romanList, value);
                    break;
                case 3:
                    transferThousands(romanList, value);
                    break;
                default:
                    break;
            }
            bit++;
        }
        StringBuilder romanStr = new StringBuilder();
        for (int i = romanList.size() - 1; i >= 0; i--) {
            romanStr.append(romanList.get(i));
        }
        return romanStr.toString();
    }

    private void transferThousands(List<String> romanList, int curNum) {
        StringBuilder thousandsStr = new StringBuilder();
        for (int i = 0; i < curNum; i++) {
            thousandsStr.append("M");
        }
        romanList.add(thousandsStr.toString());
    }

    private void transferHundreds(List<String> romanList, int curNum) {
        StringBuilder hundredsStr = new StringBuilder();
        if (curNum < FOUR) {
            for (int i = 0; i < curNum; i++) {
                hundredsStr.append("C");
            }
        } else if (curNum == FOUR) {
            hundredsStr.append("CD");
        } else if (curNum == FIVE) {
            hundredsStr.append("D");
        } else if (curNum == NINE) {
            hundredsStr.append("CM");
        } else if (curNum > FIVE) {
            hundredsStr.append("D");
            for (int i = 0; i < curNum - FIVE; i++) {
                hundredsStr.append("C");
            }
        }
        romanList.add(hundredsStr.toString());
    }

    private void transferTens(List<String> romanList, int curNum) {
        StringBuilder tensStr = new StringBuilder();
        if (curNum < FOUR) {
            for (int i = 0; i < curNum; i++) {
                tensStr.append("X");
            }
        } else if (curNum == FOUR) {
            tensStr.append("XL");
        } else if (curNum == FIVE) {
            tensStr.append("L");
        } else if (curNum == NINE) {
            tensStr.append("XC");
        } else if (curNum > FIVE) {
            tensStr.append("L");
            for (int i = 0; i < curNum - FIVE; i++) {
                tensStr.append("X");
            }
        }
        romanList.add(tensStr.toString());
    }

    private void transferSingle(List<String> romanList, int curNum) {
        StringBuilder singleStr = new StringBuilder();
        if (curNum < FOUR) {
            for (int i = 0; i < curNum; i++) {
                singleStr.append("I");
            }
        } else if (curNum == FOUR) {
            singleStr.append("IV");
        } else if (curNum == FIVE) {
            singleStr.append("V");
        } else if (curNum == NINE) {
            singleStr.append("IX");
        } else if (curNum > FIVE) {
            singleStr.append("V");
            for (int i = 0; i < curNum - FIVE; i++) {
                singleStr.append("I");
            }
        }
        romanList.add(singleStr.toString());
    }

    @Test
    public void test() {
        Code0012IntToRomanTest intToRomanTest = new Code0012IntToRomanTest();
        Assert.assertEquals("III", intToRomanTest.intToRoman(3));
        Assert.assertEquals("IV", intToRomanTest.intToRoman(4));
        Assert.assertEquals("IX", intToRomanTest.intToRoman(9));
        Assert.assertEquals("LVIII", intToRomanTest.intToRoman(58));
        Assert.assertEquals("MCMXCIV", intToRomanTest.intToRoman(1994));
    }
}
