package practice.solution;

import practice.ListNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author : Vander
 * @date :   2021/2/10
 * @description : 还有一种做法是硬做，如果若干时间内遍历不完 说明应该是有环的
 */
public class Solution1 {

    public static boolean hasCycle(ListNode head) {
        HashMap<ListNode, Object> traversedNodeMap = new HashMap<>();
        ListNode cur = head;
        while(null != cur) {
            if(!traversedNodeMap.containsKey(cur)) {
                traversedNodeMap.put(cur, null);
            } else {
                traversedNodeMap = null; // help gc
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public static boolean officialHasCycle(ListNode head) {
        HashSet<ListNode> traversedNodes = new HashSet<>();
        ListNode cur = head;
        while(null != cur) {
            if(!traversedNodes.add(cur)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

}
