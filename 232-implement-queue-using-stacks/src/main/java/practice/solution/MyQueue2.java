package practice.solution;

import java.util.Stack;

/**
 * @author : Vander
 * @date :   2021/2/18
 * @description : 每push入一个元素，都倒腾一遍，保证后入的在堆栈s1中的最底下
 */
public class MyQueue2 {

    private Stack<Integer> s1;

    private Stack<Integer> s2;

    public int front;

    /**
     * Initialize your data structure here.
     */
    public MyQueue2() {
        s1 = new Stack();
        s2 = new Stack();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (s1.empty()) {
            front = x;
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s2.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        // 输出栈为空，重新从输入栈中导过来
        Integer result = s1.pop();
        if (!s1.empty()) {
            front = s1.peek();
        }
        return result;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return front;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return s1.empty();
    }
}
