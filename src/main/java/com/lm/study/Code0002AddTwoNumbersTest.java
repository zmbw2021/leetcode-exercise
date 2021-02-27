package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

/**
 * leetcode-0002 两数相加
 * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表
 *
 * level 2
 * @author limin
 * @date 2021/1/31
 */
public class Code0002AddTwoNumbersTest {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode curNode = head;
        int sum, num1, num2, cv = 0;
        while (l1 != null || l2 != null) {
            num1 = l1 != null ? l1.val : 0;
            num2 = l2 != null ? l2.val : 0;
            sum = num1 + num2 + cv;
            cv = sum / 10;
            curNode.next = new ListNode(sum % 10);
            curNode = curNode.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (cv != 0) {
            curNode.next = new ListNode(cv);
        }
        return head.next;
    }

    @Test
    public void test() {
        Code0002AddTwoNumbersTest addTwoNumbersTest = new Code0002AddTwoNumbersTest();
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(3);
        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(4);
        ListNode result = addTwoNumbersTest.addTwoNumbers(head1, head2);
        Assert.assertEquals(7, result.val);
        Assert.assertEquals(0, result.next.val);
        Assert.assertEquals(8, result.next.next.val);
    }
}
