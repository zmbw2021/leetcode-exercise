package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode-0026 删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * level 2 100.00%
 * @author limin
 * @date 2021/2/21
 */
public class Code0026RemoveDuplicatesTest {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    @Test
    public void test() {
        Code0026RemoveDuplicatesTest removeDuplicatesTest = new Code0026RemoveDuplicatesTest();
        Assert.assertEquals(2, removeDuplicatesTest.removeDuplicates(new int[] {1, 1, 2}));
        Assert.assertEquals(5, removeDuplicatesTest.removeDuplicates(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
