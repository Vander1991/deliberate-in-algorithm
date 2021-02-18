package practice.solution;

import practice.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution1 {

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        ListNode newHead = head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode preSubListTail = dummyHead;
        boolean findNewHead = false;
        while (true) {
            ListNode curSubListHead = cur;
            ListNode nextSubListHead = null;
            int subListLen = cur == null ? 0 : 1;
            for (int i = 1; i < k; i++) {
                if (null != cur && null != cur.next) {
                    subListLen++;
                    cur = cur.next;
                } else {
                    break;
                }
            }
            // 判断是否够资格成为新的子序列，翻转序列后重新接入父序列中
            if (k == subListLen) {
                if (null != cur && null != cur.next) {
                    nextSubListHead = cur.next;
                    // 切开子序列
                    cur.next = null;
                }
                // 翻转
                if (!findNewHead) {
                    newHead = reverseSubList(curSubListHead);
                    preSubListTail.next = newHead;
                    findNewHead = true;
                } else {
                    // 前一个子序列的尾拼接翻转后的子序列的新头
                    preSubListTail.next = reverseSubList(curSubListHead);
                }
                // 拼回原来的父序列
                curSubListHead.next = nextSubListHead;
                preSubListTail = curSubListHead;
                cur = nextSubListHead;
            } else {
                break;
            }
        }
        return newHead;
    }

    /**
     * 翻转子链表，返回尾结点
     *
     * @param head
     * @return
     */
    public static ListNode reverseSubList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (null != cur) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


    public static ListNode officialReverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }

    public static ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }

}