package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode-0035 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置
 *
 * level 1 100.00%
 * @author limin
 * @date 2021/3/9
 */
public class Code0035SearchInsertTest {
    public int searchInsert(int[] nums, int target) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (target > nums[i]) {
                return i + 1;
            }
        }
        return 0;
    }

    @Test
    public void test() {
        Code0035SearchInsertTest searchInsertTest = new Code0035SearchInsertTest();
        Assert.assertEquals(2, searchInsertTest.searchInsert(new int[] {1, 3, 5, 6}, 5));
        Assert.assertEquals(1, searchInsertTest.searchInsert(new int[] {1, 3, 5, 6}, 2));
        Assert.assertEquals(4, searchInsertTest.searchInsert(new int[] {1, 3, 5, 6}, 7));
        Assert.assertEquals(0, searchInsertTest.searchInsert(new int[] {1, 3, 5, 6}, 0));
    }
}
