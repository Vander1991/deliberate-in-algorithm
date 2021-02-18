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

    public static ListNode reverseList(ListNode head) {
        ListNode curNode = head;
        return reverse(curNode);
    }

    public static ListNode reverse(ListNode curNode) {
        ListNode head;
        if (null == curNode) {
            return null;
        } else {
            ListNode nextNode = curNode.next;
            head = reverse(nextNode);
            if(null == nextNode) {
                head = curNode;
                return head;
            }
            nextNode.next = curNode;
            curNode.next = null;
        }
        return head;
    }

    /**
     * 官方写法
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}