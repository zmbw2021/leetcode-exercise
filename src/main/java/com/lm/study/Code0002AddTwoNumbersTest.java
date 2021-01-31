package com.lm.study;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode-0002 两数相加
 * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表
 *
 * @author limin
 * @date 2021/1/31
 */
public class Code0002AddTwoNumbersTest {
    /**
     * 方式1：用队列辅助处理
     * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<Integer> queue1 = createQueue(l1);
        Queue<Integer> queue2 = createQueue(l2);
        int cv = 0;
        ListNode head = null;
        ListNode cur = null;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int value = queue1.poll() + queue2.poll() + cv;
            ListNode node = new ListNode(value % 10);
            if (head == null) {
                head = node;
            } else {
                cur.next = node;
            }
            cur = node;
            cv = value / 10;
        }
        if (!queue1.isEmpty()) {
            processRemainStack(queue1, cur, cv);
        } else if (!queue2.isEmpty()) {
            processRemainStack(queue2, cur, cv);
        } else {
            if (cv != 0) {
                cur.next = new ListNode(1);
            }
        }

        return head;
    }

    private void processRemainStack(Queue<Integer> queue, ListNode cur, int cv) {
        while (!queue.isEmpty()) {
            int value = queue.poll() + cv;
            ListNode node = new ListNode(value % 10);
            cur.next = node;
            cur = node;
            cv = value / 10;
        }

        if (cv != 0) {
            cur.next = new ListNode(1);
        }
    }

    private Queue<Integer> createQueue(ListNode node) {
        Queue<Integer> queue = new LinkedList<>();
        while (node != null) {
            queue.offer(node.val);
            node = node.next;
        }
        return queue;
    }

    /**
     * 方式2：直接进行链表操作，最佳解法
     * */
    public ListNode addTwoNumbers02(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, cur = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dummyHead.next;
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
