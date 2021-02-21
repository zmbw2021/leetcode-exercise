package com.lm.study;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * leetcode-0018 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组
 *
 * @author limin
 * @date 2021/2/21
 */
public class Code0018FourSumTest {
    private static int MIN_NUM = 4;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < MIN_NUM) {
            return result;
        }
        for (int i = 0; i < nums.length - 3; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int m = j + 1; m < nums.length - 1; m++) {
                    for (int n = m + 1; n < nums.length; n++) {
                        if (nums[i] + nums[j] + nums[m] + nums[n] == target) {
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[m]);
                            list.add(nums[n]);
                            Collections.sort(list);
                            if (!result.contains(list)) {
                                result.add(list);
                            }
                            list = new ArrayList<>();
                        }
                    }
                }
            }
        }

        return result;
    }

    @Test
    public void test() {
        Code0018FourSumTest fourSumTest = new Code0018FourSumTest();
        System.out.println(fourSumTest.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
