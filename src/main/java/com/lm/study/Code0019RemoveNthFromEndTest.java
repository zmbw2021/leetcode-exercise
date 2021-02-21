package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode-0019 删除链表的倒数第N个节点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
 *
 * @author limin
 * @date 2021/2/21
 */
public class Code0019RemoveNthFromEndTest {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return null;
        }
        int target = 0;
        ListNode curNode = head;
        while (curNode != null) {
            target++;
            curNode = curNode.next;
        }
        target -= n;
        if (target < 0) {
            return null;
        }
        int curIndex = 0;
        ListNode pre = null;
        curNode = head;
        while (curNode != null) {
            if (curIndex == target) {
                if (pre == null) {
                    return curNode.next;
                }
                pre.next = curNode.next;
                break;
            }
            pre = curNode;
            curNode = curNode.next;
            curIndex++;
        }
        return head;
    }

    @Test
    public void test() {
        Code0019RemoveNthFromEndTest removeNthFromEndTest = new Code0019RemoveNthFromEndTest();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode result = removeNthFromEndTest.removeNthFromEnd(head, 2);
        Assert.assertEquals(1, result.val);
        Assert.assertEquals(2, result.next.val);
        Assert.assertEquals(3, result.next.next.val);
        Assert.assertEquals(5, result.next.next.next.val);
    }
}
