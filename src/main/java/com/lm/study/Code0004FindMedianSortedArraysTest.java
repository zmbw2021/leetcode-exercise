package com.lm.study;

import org.junit.Test;

/**
 * leetcode--0004 寻找两个正序数组的中位数
 * 给定两个大小为m和n的正序（从小到大）数组nums1和nums2。请你找出并返回这两个正序数组的中位数
 *
 * level 2
 * @author limin
 * @date 2021/1/31
 */
public class Code0004FindMedianSortedArraysTest {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int left = 0, right = nums1.length - 1, m = nums1.length, n = nums2.length;
        int numsMid1, numsMid2, numsLeft1, numsRight1, numsLeft2, numsRight2;
        while (true) {
            numsMid1 = right == -1 ? -1 : (left + right) / 2;
            numsMid2 = (m + n + 1) / 2 - (numsMid1 + 1) - 1;

            numsLeft1 = numsMid1 == -1 ? Integer.MIN_VALUE : nums1[numsMid1];
            numsRight1 = numsMid1 == nums1.length - 1 ? Integer.MAX_VALUE : nums1[numsMid1 + 1];
            numsLeft2 = numsMid2 == -1 ? Integer.MIN_VALUE : nums2[numsMid2];
            numsRight2 = numsMid2 == nums2.length - 1 ? Integer.MAX_VALUE: nums2[numsMid2 + 1];
            // 说明分割线应该往左移
            if (numsLeft1 > numsRight2) {
                right--;
            } else if (numsLeft2 > numsRight1) {
                left++;
            } else {
                break;
            }
        }

        int numsMax = Math.max(numsLeft1, numsLeft2);
        int numsMin = Math.min(numsRight1, numsRight2);
        return (m + n) % 2 == 0 ? (numsMax + numsMin) / 2.0 : numsMax;
    }

    @Test
    public void test() {
        Code0004FindMedianSortedArraysTest findMedianSortedArraysTest = new Code0004FindMedianSortedArraysTest();
        System.out.println(findMedianSortedArraysTest.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArraysTest.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(findMedianSortedArraysTest.findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}));
        System.out.println(findMedianSortedArraysTest.findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(findMedianSortedArraysTest.findMedianSortedArrays(new int[]{2}, new int[]{}));
    }
}
