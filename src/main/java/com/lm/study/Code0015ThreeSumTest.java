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
 * level 2 57.48%
 * @author limin
 * @date 2021/2/21
 */
public class Code0015ThreeSumTest {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int first = 0; first < n; ++first) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = n - 1;
            int target = -nums[first];
            for (int second = first + 1; second < n; ++second) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {
        Code0015ThreeSumTest threeSumTest = new Code0015ThreeSumTest();
        List<List<Integer>> results1 = threeSumTest.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        List<List<Integer>> results2 = threeSumTest.threeSum(new int[]{});
        List<List<Integer>> results3 = threeSumTest.threeSum(new int[]{0});
    }
}
