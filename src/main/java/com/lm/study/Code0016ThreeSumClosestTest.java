package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * leetcode-0016 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * level 2 81.31%
 * @author limin
 * @date 2021/2/21
 */
public class Code0016ThreeSumClosestTest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length, best = 10000000;
        for (int i = 0; i < n; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    int k0 = k - 1;
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    int j0 = j + 1;
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }

    @Test
    public void test() {
        Code0016ThreeSumClosestTest threeSumClosestTest = new Code0016ThreeSumClosestTest();
        Assert.assertEquals(2, threeSumClosestTest.threeSumClosest(new int[] {-1, 2, 1, -4}, 1));
    }
}
