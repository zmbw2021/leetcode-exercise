package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode-0033 搜索旋转排序数组
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的索引，否则返回 -1
 *
 * level 1 100.00%
 * @author limin
 * @date 2021/3/9
 */
public class Code0033SearchTest {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        if (nums[0] > target) {
            for (int i = nums.length - 1; i > 0; i--) {
                if (nums[i] < target || nums[i] > nums[0]) {
                    return -1;
                }
                if (nums[i] == target) {
                    return i;
                }
            }
        } else if (nums[0] < target) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > target || nums[i] < nums[0]) {
                    return -1;
                }
                if (nums[i] == target) {
                    return i;
                }
            }
        } else {
            return 0;
        }
        return -1;
    }

    @Test
    public void test() {
        Code0033SearchTest searchTest = new Code0033SearchTest();
        Assert.assertEquals(4, searchTest.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0));
        Assert.assertEquals(-1, searchTest.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 3));
        Assert.assertEquals(-1, searchTest.search(new int[] {1}, 0));
    }
}
