import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : Vander
 * @date :   2021/2/20
 * @description :
 */
public class DequeTest {

    @Test
    public void test() {
        Deque<Integer> deque = new LinkedList<>();
        // 测试先入先出，链表头部为第一个元素，next指向下个元素
        for(int i=0; i<3; i++) {
            deque.offer(i);
        }
        while(!deque.isEmpty()) {
            System.out.print(deque.poll() + " ");
        }
        System.out.println();

        // 测试先入后出
        for(int i=0; i<3; i++) {
            deque.offer(i);
        }
        while(!deque.isEmpty()) {
            System.out.print(deque.pollLast() + " ");
        }
        System.out.println();
    }

}
