package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode-0011 盛水最多的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别
 * 为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水
 *
 * level 2 100.00%
 * @author limin
 * @date 2021/2/21
 */
public class Code0011MaxAreaTest {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right) {
            if (height[left] < height[right]) {
                int temp = height[left];
                max = Math.max(max, temp * (right - left));
                while (left < right && temp >= height[left]) {
                    left++;
                }
            } else {
                int temp = height[right];
                max = Math.max(max, temp * (right - left));
                while (left < right && temp >= height[right]) {
                    right--;
                }
            }
        }
        return max;
    }

    @Test
    public void test() {
        Code0011MaxAreaTest maxAreaTest = new Code0011MaxAreaTest();
        Assert.assertEquals(49, maxAreaTest.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
        Assert.assertEquals(1, maxAreaTest.maxArea(new int[] {1, 1}));
        Assert.assertEquals(16, maxAreaTest.maxArea(new int[] {4, 3, 2, 1, 4}));
    }
}
