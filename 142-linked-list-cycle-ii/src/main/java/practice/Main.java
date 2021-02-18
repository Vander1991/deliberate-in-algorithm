package practice;

import practice.solution.Solution1;
import practice.solution.Solution2;

/**
 * @author : Vander
 * @date :   2021/2/8
 * @description :
 */
public class Main {

    private static ListNode init(int nodeNum) {
        ListNode head = new ListNode(1);
        ListNode curNode = head;
        for (int i = 1; i < nodeNum; i++) {
            curNode.next = new ListNode(i + 1);
            curNode = curNode.next;
        }
        ListNode node3 = new ListNode(3);
        curNode.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        node4.next = curNode;
        return head;
    }

    public static void main(String[] args) {
        // 自己实现
        ListNode head1 = init(4);
        ListNode result1 = Solution1.detectCycle(head1);
        System.out.println("result1 : " + result1);
        // 快慢指针
        ListNode head2 = init(2);
        ListNode result2 = Solution2.detectCycle(head2);
        System.out.println("result2 : " + result2);
    }

}
