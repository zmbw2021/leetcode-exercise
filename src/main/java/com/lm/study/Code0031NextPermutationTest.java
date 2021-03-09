package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * leetcode-0031 下一个排列
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列
 *
 * level 1 98.28%
 * @author limin
 * @date 2021/3/9
 */
public class Code0031NextPermutationTest {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int index = -1;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                index = i - 1;
                break;
            }
        }

        if (index == -1) {
            Arrays.sort(nums);
            return;
        }
        for (int i = index + 1; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }

        for (int i = index + 1; i < nums.length; i++) {
            if (nums[index] < nums[i]) {
                swap(nums, index, i);
                break;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    @Test
    public void test() {
        Code0031NextPermutationTest nextPermutationTest = new Code0031NextPermutationTest();
        int[] arr1 = new int[] {1, 2, 3};
        nextPermutationTest.nextPermutation(arr1);
        Assert.assertEquals(1, arr1[0]);
        Assert.assertEquals(3, arr1[1]);
        Assert.assertEquals(2, arr1[2]);
        int[] arr2 = new int[] {3, 2, 1};
        nextPermutationTest.nextPermutation(arr2);
        Assert.assertEquals(1, arr2[0]);
        Assert.assertEquals(2, arr2[1]);
        Assert.assertEquals(3, arr2[2]);
        int[] arr3 = new int[] {1, 1, 5};
        nextPermutationTest.nextPermutation(arr3);
        Assert.assertEquals(1, arr3[0]);
        Assert.assertEquals(5, arr3[1]);
        Assert.assertEquals(1, arr3[2]);
    }
}
