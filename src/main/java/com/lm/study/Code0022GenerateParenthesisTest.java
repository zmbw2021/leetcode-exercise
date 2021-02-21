package com.lm.study;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode-0022 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。
 *
 * @author limin
 * @date 2021/2/21
 */
public class Code0022GenerateParenthesisTest {
    private static final String LEFT_BRACKET = "(";

    public List<String> generateParenthesis(int n) {
        if (n < 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        processBracket(0, n, "(", new StringBuilder(), result);
        return result;
    }

    private void processBracket(int bracketDiff, int n, String bracket,
                                StringBuilder stringBuilder, List<String> result) {
        if (n == 0 && bracketDiff == 0) {
            result.add(stringBuilder.toString());
            return;
        }
        StringBuilder tmpStrBuilder = new StringBuilder(stringBuilder);
        if (LEFT_BRACKET.equals(bracket)) {
            bracketDiff++;
            n--;
        } else {
            bracketDiff--;
        }
        tmpStrBuilder.append(bracket);
        if (bracketDiff == 0) {
            processBracket(bracketDiff, n, "(", tmpStrBuilder, result);
        } else if (n == 0) {
            processBracket(bracketDiff, n, ")", tmpStrBuilder, result);
        } else {
            processBracket(bracketDiff, n, "(", tmpStrBuilder, result);
            processBracket(bracketDiff, n, ")", tmpStrBuilder, result);
        }
    }

    @Test
    public void test() {
        Code0022GenerateParenthesisTest generateParenthesisTest = new Code0022GenerateParenthesisTest();
        System.out.println(generateParenthesisTest.generateParenthesis(3));
    }
}
