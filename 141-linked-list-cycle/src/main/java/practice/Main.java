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
        curNode.next = curNode;
        return head;
    }

    public static void main(String[] args) {
        // 自己实现
        ListNode head1 = init(4);
        boolean result1 = Solution1.hasCycle(head1);
        System.out.println("result1 : " + result1);
        // 官方实现
        ListNode head2 = init(4);
        boolean result2 = Solution1.officialHasCycle(head2);
        System.out.println("result2 : " + result2);
        // 官方实现
        ListNode head3 = init(4);
        boolean result3 = Solution2.hasCycle(head3);
        System.out.println("result3 : " + result3);
    }

}
