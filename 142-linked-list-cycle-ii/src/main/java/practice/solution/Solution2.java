package practice.solution;

import practice.ListNode;

/**
 * @author : Vander
 * @date :   2021/2/16
 * @description :
 */
public class Solution2 {

    public static ListNode detectCycle(ListNode head) {
        boolean meet = false;
        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = head;

        if(null == fast) {
            return null;
        }

        do {
            // 快慢指针都先走一步
            if(null != fast.next) {
                fast = fast.next.next;
            }
            slow = slow.next;

            if(fast == slow) {
                meet = true;
                break;
            }
        }
        while (null != fast && null != fast.next);

        // 慢指针与快指针相遇时，temp从头部出发，当于slow相遇时，即为入口处
        if(meet) {
            while(temp != slow) {
                temp = temp.next;
                slow = slow.next;
            }
        } else {
            return null;
        }
        return temp;
    }

    public static ListNode officialDetectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
