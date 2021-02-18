package practice.solution;

import practice.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * } // 虽然自己能实现，但是比起官方写法较为复杂
 */
public class Solution2 {

    /**
     * 官方写法
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode cur = head;
        ListNode pre = null;
        while(null != cur) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

}