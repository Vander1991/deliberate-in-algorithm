package practice.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : Official
 * @date :   2021/2/18
 * @description : 官方实现：一直queue1的队头是栈顶
 */
public class MyStack2 {

    /**
     * queue1作为出栈的队列
     */
    Queue<Integer> queue1;
    /**
     * queue2作为入栈的辅助队列
     */
    Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack2() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }

}