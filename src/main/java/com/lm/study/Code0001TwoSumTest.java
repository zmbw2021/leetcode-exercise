package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode-0001 两数之和
 * 给定一个整数数组nums和一个整数目标值target，请你在该数组中找出 和为目标值的那两个整数，并返回它们的数组下标
 *
 * @author limin
 * @date 2021/1/31
 */
public class Code0001TwoSumTest {
    private static final int MIN_NUMS = 2;

    /**
     * 方法1：遍历数组
     */
    public int[] twoSum01(int[] nums, int target) {
        if (nums == null || nums.length < MIN_NUMS) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] res = new int[2];
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return null;
    }

    /**
     * 方式2：HashMap
     * */
    public int[] twoSum02(int[] nums, int target) {
        // 1.先生成一个HashMap，将数据存入
        Map<Integer, List<Integer>> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            List<Integer> tmp = map.get(nums[i]);
            if (tmp == null) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            } else {
                tmp.add(i);
            }
        }

        // 2.在Map中寻找能够配对的元素
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int i = entry.getKey();
            List<Integer> tmp = map.get(target - i);
            if (tmp != null) {
                if (i != target - i) {
                    int[] res = new int[2];
                    res[0] = entry.getValue().get(0);
                    res[1] = tmp.get(0);
                    return res;
                } else if (tmp.size() > 1) {
                    int[] res = new int[2];
                    res[0] = tmp.get(0);
                    res[1] = tmp.get(1);
                    return res;
                }
            }
        }
        return null;
    }

    /**
     * 方式3：一趟HashMap，最佳解法
     * */
    public int[] twoSum03(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    @Test
    public void test() {
        Code0001TwoSumTest twoSumTest = new Code0001TwoSumTest();
        int[] result = twoSumTest.twoSum03(new int[] {2, 7, 11, 15}, 9);
        int[] expected = {0, 1};
        Assert.assertEquals(2, result.length);
        for (int i = 0; i < result.length; i++) {
            Assert.assertEquals(expected[i], result[i]);
        }
    }
}
