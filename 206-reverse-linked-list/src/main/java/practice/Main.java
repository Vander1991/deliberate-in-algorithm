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
        return head;
    }

    public static void main(String[] args) {
        // 递归实现
        ListNode head1 = init(3);
        head1 = Solution1.reverseList(head1);
        System.out.println(head1);
        // 遍历实现
        ListNode head2 = init(5);
        head2 = Solution2.reverseList(head2);
        System.out.println(head2);
    }

}
