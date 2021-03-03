package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode-0024 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * level 1 100.00%
 * @author limin
 * @date 2021/2/21
 */
public class Code0024SwapPairsTest {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = pre.next;
        ListNode tmpHead = null;
        ListNode resultNode = cur;
        while (true) {
            pre.next = cur.next;
            cur.next = pre;
            if (tmpHead != null) {
                tmpHead.next = cur;
            }
            tmpHead = pre;
            pre = pre.next;
            if (pre == null) {
                break;
            }
            cur = pre.next;
            if (cur == null) {
                break;
            }
        }
        return resultNode;
    }

    @Test
    public void test() {
        Code0024SwapPairsTest swapPairsTest = new Code0024SwapPairsTest();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode result = swapPairsTest.swapPairs(head);
        Assert.assertEquals(2, result.val);
        Assert.assertEquals(1, result.next.val);
        Assert.assertEquals(4, result.next.next.val);
        Assert.assertEquals(3, result.next.next.next.val);
    }
}
