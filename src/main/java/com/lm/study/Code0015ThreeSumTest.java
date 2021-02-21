package com.lm.study;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode-0015 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组
 *
 * @author limin
 * @date 2021/2/21
 */
public class Code0015ThreeSumTest {
    private static final int MIN_LENGTH = 3;

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < MIN_LENGTH) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            process(nums, i + 1, -nums[i], result);
        }

        return result;
    }

    private void process(int[] nums, int startIndex, int target, List<List<Integer>> result) {
        if (nums.length - startIndex + 1 < MIN_LENGTH) {
            return;
        }
        int start = startIndex;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] < target) {
                start++;
            } else if (nums[start] + nums[end] > target) {
                end--;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[startIndex - 1]);
                list.add(nums[start++]);
                list.add(nums[end]);
                if (!result.contains(list)) {
                    result.add(list);
                }
            }
        }
    }

    @Test
    public void test() {
        Code0015ThreeSumTest threeSumTest = new Code0015ThreeSumTest();
        List<List<Integer>> results1 = threeSumTest.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        List<List<Integer>> results2 = threeSumTest.threeSum(new int[]{});
        List<List<Integer>> results3 = threeSumTest.threeSum(new int[]{0});
    }
}
