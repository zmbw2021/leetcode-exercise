package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode--0004 寻找两个正序数组的中位数
 * 给定两个大小为m和n的正序（从小到大）数组nums1和nums2。请你找出并返回这两个正序数组的中位数
 *
 * @author limin
 * @date 2021/1/31
 */
public class Code0004FindMedianSortedArraysTest {
    /**
     * 方式1：合并两个数组，再求新数组的中位数
     * */
    public double findMedianSortedArrays01(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0;
        }
        if (nums1 == null) {
            return findMedianSortedArrays(nums2);
        }
        if (nums2 == null) {
            return findMedianSortedArrays(nums1);
        }

        int len = nums1.length + nums2.length;
        int[] arr = new int[len];
        int index = -1;
        int numsIndex1 = 0;
        int numsIndex2 = 0;
        while (numsIndex1 < nums1.length && numsIndex2 < nums2.length) {
            if (nums1[numsIndex1] < nums2[numsIndex2]) {
                arr[++index] = nums1[numsIndex1++];
            } else {
                arr[++index] = nums2[numsIndex2++];
            }
        }
        while (numsIndex1 < nums1.length) {
            arr[++index] = nums1[numsIndex1++];
        }
        while (numsIndex2 < nums2.length) {
            arr[++index] = nums2[numsIndex2++];
        }

        return findMedianSortedArrays(arr);
    }

    private double findMedianSortedArrays(int[] nums) {
        int len = nums.length;
        if (len % 2 == 0) {
            return 1.0 * (nums[len / 2 - 1] + nums[len / 2]) / 2;
        } else {
            return 1.0 * nums[len / 2];
        }
    }

    /**
     * 方式2：二分
     * */
    public double findMedianSortedArrays02(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays02(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m, ansi = -1;
        // median1：前一部分的最大值
        // median2：后一部分的最小值
        int median1 = 0, median2 = 0;

        while (left <= right) {
            // 前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
            // 后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            // nums_im1, nums_i, nums_jm1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1], nums2[j]
            int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
            int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (nums_im1 <= nums_j) {
                ansi = i;
                median1 = Math.max(nums_im1, nums_jm1);
                median2 = Math.min(nums_i, nums_j);
                left = i + 1;
            }
            else {
                right = i - 1;
            }
        }

        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }

    @Test
    public void test() {
        Code0004FindMedianSortedArraysTest findMedianSortedArraysTest = new Code0004FindMedianSortedArraysTest();
        Assert.assertEquals(2.00000, findMedianSortedArraysTest.findMedianSortedArrays01(new int[]{1, 3}, new int[]{2}));
        Assert.assertEquals(2.50000, findMedianSortedArraysTest.findMedianSortedArrays01(new int[]{1, 2}, new int[]{3, 4}));
        Assert.assertEquals(0.00000, findMedianSortedArraysTest.findMedianSortedArrays01(new int[]{0, 0}, new int[]{0, 0}));
        Assert.assertEquals(1.00000, findMedianSortedArraysTest.findMedianSortedArrays01(new int[]{}, new int[]{1}));
        Assert.assertEquals(2.00000, findMedianSortedArraysTest.findMedianSortedArrays01(new int[]{2}, new int[]{}));
    }
}
