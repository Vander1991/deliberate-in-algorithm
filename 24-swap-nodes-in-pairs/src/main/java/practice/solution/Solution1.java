package practice.solution;

import practice.ListNode;

/**
 * @author : Vander
 * @date :   2021/2/10
 * @description :
 */
public class Solution1 {

    public static ListNode swapPairs(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next1 = null;
        ListNode newHead = null;

        if(null == cur || (null != cur && null == cur.next)) {
            return cur;
        }

        newHead = cur.next;
        while (null != cur) {
            next1 = cur.next;
            // head的pre为null
            if(null != pre && null != next1) {
                pre.next = next1;
            }

            if(null != next1) {
                pre = cur;
                ListNode temp = next1.next;
                next1.next = cur;
                cur.next = temp;
                cur = temp;
            } else {
                break;
            }
        }
        return newHead;
    }

    /**
     * 官方写法：关键在于构建dummyHead作为一个虚拟结点，表示已经交换完的最末的节点
     *
     * @return
     */
    public static ListNode officialSwapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        dummyHead.next = head;
        ListNode node1 = null;
        ListNode node2 = null;
        while(null != cur.next && null != cur.next.next) {
            node1 = cur.next;
            node2 = cur.next.next;
            cur.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            // 已经轮换完的位置
            cur = node1;
        }
        return dummyHead.next;
    }

}
