package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode-0026 删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * @author limin
 * @date 2021/2/21
 */
public class Code0026RemoveDuplicatesTest {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int i = 0;
        int pre = nums[i];
        int tmp = i + 1;
        while (tmp < nums.length) {
            if (pre != nums[tmp]) {
                swap(nums, ++i, tmp);
                pre = nums[i];
            }
            tmp++;
        }
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    @Test
    public void test() {
        Code0026RemoveDuplicatesTest removeDuplicatesTest = new Code0026RemoveDuplicatesTest();
        Assert.assertEquals(2, removeDuplicatesTest.removeDuplicates(new int[] {1, 1, 2}));
        Assert.assertEquals(5, removeDuplicatesTest.removeDuplicates(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
