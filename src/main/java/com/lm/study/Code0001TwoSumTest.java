package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * leetcode-0001 两数之和
 * 给定一个整数数组nums和一个整数目标值target，请你在该数组中找出和为目标值的那两个整数，并返回它们的数组下标
 *
 * level 1 100%
 * @author limin
 * @date 2021/1/31
 */
public class Code0001TwoSumTest {
    private static final int MIN_NUMS = 2;

    public int[] twoSum(int[] nums, int target) {
        if (nums == null && nums.length < MIN_NUMS) {
            return new int[] {};
        }
        HashMap<Integer, Integer> map = new HashMap<>(16);
        // 一趟哈希
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }

    @Test
    public void test() {
        Code0001TwoSumTest twoSumTest = new Code0001TwoSumTest();
        int[] result = twoSumTest.twoSum(new int[] {2, 7, 11, 15}, 9);
        int[] expected = {0, 1};
        Assert.assertEquals(2, result.length);
        for (int i = 0; i < result.length; i++) {
            Assert.assertEquals(expected[i], result[i]);
        }
    }
}
