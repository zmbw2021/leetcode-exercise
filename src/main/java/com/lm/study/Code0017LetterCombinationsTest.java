package com.lm.study;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode-0017 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按任意顺序返回
 *
 * @author limin
 * @date 2021/2/21
 */
public class Code0017LetterCombinationsTest {
    private static Map<Character, List<String>> map;
    static {
        map = new HashMap<>();
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() < 1) {
            return new ArrayList<>();
        }
        List<String> result = map.get(digits.charAt(0));
        for (int i = 1; i < digits.length(); i++) {
            result = merge(result, map.get(digits.charAt(i)));
        }
        return result;
    }

    private List<String> merge(List<String> curList, List<String> targetList) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < curList.size(); i++) {
            for (int j = 0; j < targetList.size(); j++) {
                result.add(curList.get(i) + targetList.get(j));
            }
        }
        return result;
    }

    @Test
    public void test() {
        Code0017LetterCombinationsTest letterCombinationsTest = new Code0017LetterCombinationsTest();
        System.out.println(letterCombinationsTest.letterCombinations("23"));
        System.out.println(letterCombinationsTest.letterCombinations(""));
        System.out.println(letterCombinationsTest.letterCombinations("2"));
    }
}
