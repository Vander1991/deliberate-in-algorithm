package practice.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : Vander
 * @date :   2021/2/18
 * @description : 自己实现的，思路是每次倒腾剩下一个元素就是栈顶元素，pop跟top的时间复杂度都是O(n)
 */
public class MyStack1 {

    private Queue<Integer> q1;

    private Queue<Integer> q2;

    /**
     * Initialize your data structure here.
     */
    public MyStack1() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (!q1.isEmpty()) {
            q1.offer(x);
        } else if (!q2.isEmpty()) {
            q2.offer(x);
        } else {
            q1.offer(x);
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (!q2.isEmpty() && q1.isEmpty()) {
            // 倒腾q2的元素到q1
            while(q2.size() > 1) {
                q1.offer(q2.poll());
            }
            return q2.poll();
        } else if (!q1.isEmpty() && q2.isEmpty()) {
            // 倒腾q1的元素到q2
            while(q1.size() > 1) {
                q2.offer(q1.poll());
            }
            return q1.poll();
        } else {
            throw new RuntimeException("Both q1 and q2 is empty!!!");
        }
    }

    /**
     * Get the top element.
     */
    public int top() {
        int ele = this.pop();
        this.push(ele);
        return ele;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
