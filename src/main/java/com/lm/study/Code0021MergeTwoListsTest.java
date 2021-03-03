package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode-0021 合并两个有序链表
 * 将两个升序链表合并为一个新的升序链表并返回
 *
 * level 1 100.00%
 * @author limin
 * @date 2021/2/21
 */
public class Code0021MergeTwoListsTest {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head;
        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return head;
    }

    @Test
    public void test() {
        Code0021MergeTwoListsTest mergeTwoListsTest = new Code0021MergeTwoListsTest();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        ListNode resultNode = mergeTwoListsTest.mergeTwoLists(head1, head2);
        Assert.assertEquals(1, resultNode.val);
        Assert.assertEquals(1, resultNode.next.val);
        Assert.assertEquals(2, resultNode.next.next.val);
        Assert.assertEquals(2, resultNode.next.next.next.val);
        Assert.assertEquals(3, resultNode.next.next.next.next.val);
        Assert.assertEquals(4, resultNode.next.next.next.next.next.val);
    }
}
