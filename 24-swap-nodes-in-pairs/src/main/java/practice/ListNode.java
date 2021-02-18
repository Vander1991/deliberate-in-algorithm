package practice;


/**
 * @author : Vander
 * @date :   2021/2/8
 * @description :
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode cur = this;
        while(null != cur) {
            stringBuilder.append(cur.val).append("->");
            cur = cur.next;
        }
        stringBuilder.append("null");
        return stringBuilder.toString();
    }

}