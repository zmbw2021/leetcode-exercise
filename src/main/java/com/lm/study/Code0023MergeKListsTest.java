package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode-0023 合并k个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。请你将所有链表合并到一个升序链表中，返回合并后的链表
 *
 * @author limin
 * @date 2021/2/21
 */
public class Code0023MergeKListsTest {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode[] curHeads = new ListNode[lists.length];
        for (int i = 0; i < lists.length; i++) {
            curHeads[i] = lists[i];
        }

        ListNode head = new ListNode();
        ListNode curNode = head;
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        boolean flag;
        while (true) {
            for (int i = 0; i < lists.length; i++) {
                if (curHeads[i] != null && minValue > curHeads[i].val) {
                    minValue = curHeads[i].val;
                    minIndex = i;
                }
            }

            flag = false;
            for (int i = 0; i < lists.length; i++) {
                if (curHeads[i] != null) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                break;
            }
            curNode.next = curHeads[minIndex];
            curNode = curNode.next;
            curHeads[minIndex] = curHeads[minIndex].next;
            minIndex = -1;
            minValue = Integer.MAX_VALUE;
        }

        return head.next;
    }

    @Test
    public void test() {
        Code0023MergeKListsTest mergeKListsTest = new Code0023MergeKListsTest();
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);
        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);
        ListNode result = mergeKListsTest.mergeKLists(lists);
        Assert.assertEquals(1, result.val);
        Assert.assertEquals(1, result.next.val);
        Assert.assertEquals(2, result.next.next.val);
        Assert.assertEquals(3, result.next.next.next.val);
        Assert.assertEquals(4, result.next.next.next.next.val);
        Assert.assertEquals(4, result.next.next.next.next.next.val);
        Assert.assertEquals(5, result.next.next.next.next.next.next.val);
        Assert.assertEquals(6, result.next.next.next.next.next.next.next.val);
    }
}
