package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode-0025 K个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * @author limin
 * @date 2021/2/21
 */
public class Code0025ReverseKGroupTest {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }
        ListNode preHead = head;
        int sum = 0;
        while (preHead != null) {
            sum++;
            preHead = preHead.next;
        }
        int times = 0;
        int index = 0;
        ListNode result = null;
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmpNode = null;
        ListNode tailNode;
        ListNode tmp;
        while (times < sum / k) {
            tailNode = cur;
            while (index < k) {
                tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
                index++;
            }
            times++;
            index = 0;
            if (result == null) {
                result = pre;
            }
            if (tmpNode == null) {
                tmpNode = tailNode;
            } else {
                tmpNode.next = pre;
                tmpNode = tailNode;
            }
            pre = null;
        }

        if (result == null) {
            return head;
        }
        preHead = result;
        while (preHead.next != null) {
            preHead = preHead.next;
        }
        preHead.next = cur;
        return result;
    }

    @Test
    public void test() {
        Code0025ReverseKGroupTest reverseKGroupTest = new Code0025ReverseKGroupTest();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode result = reverseKGroupTest.reverseKGroup(head, 2);
        Assert.assertEquals(2, result.val);
        Assert.assertEquals(1, result.next.val);
        Assert.assertEquals(4, result.next.next.val);
        Assert.assertEquals(3, result.next.next.next.val);
        Assert.assertEquals(5, result.next.next.next.next.val);
    }
}
