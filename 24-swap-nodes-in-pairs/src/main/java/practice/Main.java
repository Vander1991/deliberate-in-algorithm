package practice;

import practice.solution.Solution1;

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
        // 自己实现
        ListNode head1 = init(4);
        head1 = Solution1.swapPairs(head1);
        System.out.println("head1 : " + head1);
        // 官方实现
        ListNode head2 = init(5);
        head2 = Solution1.officialSwapPairs(head2);
        System.out.println("head2 : " + head2);
    }

}
