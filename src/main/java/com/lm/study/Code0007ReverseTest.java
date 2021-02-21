package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode--0007 整数反转
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 *
 * @author limin
 * @date 2021/2/21
 */
public class Code0007ReverseTest {
    /**
     * 解法一：利用字符数组进行交换
     * */
    public int reverse(int x) {
        // 1.首先判断是正数还是负数
        boolean neg = x >= 0 ? false : true;
        // 2.使用字符数组进行交换
        long lx = x;
        String tmp = String.valueOf(Math.abs(lx));
        char[] chs = tmp.toCharArray();
        int i = 0;
        int j = chs.length - 1;
        char tmpCh;
        while (i < j) {
            tmpCh = chs[i];
            chs[i] = chs[j];
            chs[j] = tmpCh;
            i++;
            j--;
        }
        // 3.去掉前面的0
        StringBuilder stringBuilder = new StringBuilder();
        if (neg) {
            stringBuilder.append("-");
        }
        boolean flag = true;
        for (char ch : chs) {
            if (flag && ch == '0') {
                continue;
            } else {
                flag = false;
                stringBuilder.append(ch);
            }
        }
        if (stringBuilder.length() == 0) {
            return 0;
        }
        long l = Long.parseLong(stringBuilder.toString());
        return l > Integer.MAX_VALUE || l < Integer.MIN_VALUE ? 0 : (int) l;
    }

    /**
     * 解法二：弹出和推入数字&溢出前检查
     * */
    public int reverse02(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            // 处理正向溢出和负向溢出情况
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    @Test
    public void test() {
        Code0007ReverseTest reverseTest = new Code0007ReverseTest();
        Assert.assertEquals(321, reverseTest.reverse02(123));
        Assert.assertEquals(-321, reverseTest.reverse02(-123));
        Assert.assertEquals(21, reverseTest.reverse02(120));
        Assert.assertEquals(0, reverseTest.reverse02(0));
    }
}
