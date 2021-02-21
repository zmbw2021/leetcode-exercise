package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode-0011 盛水最多的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别
 * 为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水
 *
 * @author limin
 * @date 2021/2/21
 */
public class Code0011MaxAreaTest {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(Math.min(height[i], height[j]) * (j - i), maxArea);
            }
        }
        return maxArea;
    }

    @Test
    public void test() {
        Code0011MaxAreaTest maxAreaTest = new Code0011MaxAreaTest();
        Assert.assertEquals(49, maxAreaTest.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
        Assert.assertEquals(1, maxAreaTest.maxArea(new int[] {1, 1}));
        Assert.assertEquals(16, maxAreaTest.maxArea(new int[] {4, 3, 2, 1, 4}));
    }
}
