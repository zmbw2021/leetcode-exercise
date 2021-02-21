package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode-0027 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * @author limin
 * @date 2021/2/21
 */
public class Code0027RemoveElementTest {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int i = 0;
        int j = nums.length;
        while (i < j) {
            if (nums[i] == val) {
                swap(nums, i, --j);
            } else {
                i++;
            }
        }
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    @Test
    public void test() {
        Code0027RemoveElementTest removeElementTest = new Code0027RemoveElementTest();
        Assert.assertEquals(2, removeElementTest.removeElement(new int[] {3, 2, 2, 3}, 3));
        Assert.assertEquals(5, removeElementTest.removeElement(new int[] {0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }
}
