package practice.solution;

import practice.ListNode;

/**
 * @author : Vander
 * @date :   2021/2/16
 * @description : 龟兔赛跑算法，乌龟每次走一步，兔子每次走两步，若有环，乌龟迟早追上兔子
 */
public class Solution2 {

    public static boolean hasCycle(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode slowTraverser = dummyHead;
        ListNode fastTraverser = head;
        if(null == fastTraverser) {
            return false;
        }
        while(null != fastTraverser.next && null != fastTraverser.next.next) {
            if(slowTraverser == fastTraverser) {
                return true;
            }
            fastTraverser = fastTraverser.next.next;
            slowTraverser = slowTraverser.next;
        }
        return false;
    }

}
