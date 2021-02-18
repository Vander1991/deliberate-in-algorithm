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
        ListNode head1 = init(2);
        head1 = Solution1.reverseKGroup(head1, 2);
        System.out.println(head1);
    }
}
