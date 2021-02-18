package practice.solution;

import practice.ListNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author : Vander
 * @date :   2021/2/10
 * @description :
 */
public class Solution1 {

    public static ListNode detectCycle(ListNode head) {
        HashSet<ListNode> traversedNodes = new HashSet<>();
        ListNode cur = head;
        while(null != cur) {
            if(!traversedNodes.add(cur)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    public static ListNode officialdetectCycle(ListNode head) {
        return null;
    }

}
