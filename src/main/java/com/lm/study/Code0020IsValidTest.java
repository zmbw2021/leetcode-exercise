package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * leetcode-0020 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效
 *
 * @author limin
 * @date 2021/2/21
 */
public class Code0020IsValidTest {
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        char[] target = s.toCharArray();
        Stack<Character> signStack = new Stack<>();
        for (int i = 0; i < target.length; i++) {
            if (target[i] == ')' || target[i] == ']' || target[i] == '}') {
                if (signStack.isEmpty()) {
                    return false;
                }
                char tmp = signStack.pop();
                if ((target[i] == ')' && tmp != '(') ||
                        (target[i] == ']' && tmp != '[') ||
                        (target[i] == '}' && tmp != '{')){
                    return false;
                }
            } else {
                signStack.push(target[i]);
            }
        }
        return signStack.isEmpty() ? true : false;
    }

    @Test
    public void test() {
        Code0020IsValidTest isValidTest = new Code0020IsValidTest();
        Assert.assertTrue(isValidTest.isValid("()[]{}"));
        Assert.assertTrue(isValidTest.isValid("()"));
        Assert.assertTrue(isValidTest.isValid("{[]}"));
        Assert.assertFalse(isValidTest.isValid("(]"));
        Assert.assertFalse(isValidTest.isValid("([)]"));
    }
}
