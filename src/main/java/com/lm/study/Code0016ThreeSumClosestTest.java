package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode-0016 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * @author limin
 * @date 2021/2/21
 */
public class Code0016ThreeSumClosestTest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new RuntimeException("input is not correct, please check!");
        }
        int minGap = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (Math.abs(nums[i] + nums[j] + nums[k] - target) < minGap) {
                        minGap = Math.abs(nums[i] + nums[j] + nums[k] - target);
                        result = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        Code0016ThreeSumClosestTest threeSumClosestTest = new Code0016ThreeSumClosestTest();
        Assert.assertEquals(2, threeSumClosestTest.threeSumClosest(new int[] {-1, 2, 1, -4}, 1));
    }
}
