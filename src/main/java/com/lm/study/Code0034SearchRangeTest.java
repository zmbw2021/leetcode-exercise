package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode-0034 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * level 1 100.00%
 * @author limin
 * @date 2021/3/9
 */
public class Code0034SearchRangeTest {
    public int[] searchRange(int[] nums, int target) {
        int index = process(nums, 0, nums.length - 1, target);
        if (index == -1) {
            return new int[] {-1, -1};
        }
        int leftIndex = index - 1;
        while (leftIndex >= 0) {
            if (nums[leftIndex] != nums[index]) {
                break;
            }
            leftIndex--;
        }
        int rightIndex = index + 1;
        while (rightIndex < nums.length) {
            if (nums[rightIndex] != nums[index]) {
                break;
            }
            rightIndex++;
        }

        return new int[] {leftIndex + 1, rightIndex - 1};
    }

    private int process(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] > target) {
            return process(nums, left, mid - 1, target);
        } else if (nums[mid] < target) {
            return process(nums, mid + 1, right, target);
        } else {
            return mid;
        }
    }

    @Test
    public void test() {
        Code0034SearchRangeTest searchRangeTest = new Code0034SearchRangeTest();
        int[] result1 = searchRangeTest.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        Assert.assertEquals(3, result1[0]);
        Assert.assertEquals(4, result1[1]);
        int[] result2 = searchRangeTest.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        Assert.assertEquals(-1, result2[0]);
        Assert.assertEquals(-1, result2[1]);
        int[] result3 = searchRangeTest.searchRange(new int[]{}, 0);
        Assert.assertEquals(-1, result3[0]);
        Assert.assertEquals(-1, result3[1]);
    }
}
