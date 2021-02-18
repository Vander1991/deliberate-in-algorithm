package practice.solution;

import java.util.Stack;

/**
 * @author : Vander
 * @date :   2021/2/18
 * @description : pop的时候优先把输出栈pop完，pop完后再重新倒腾输出栈
 */
public class MyQueue1 {

    private Stack<Integer> inputStack;

    private Stack<Integer> outputStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue1() {
        inputStack = new Stack();
        outputStack = new Stack();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inputStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        // 输出栈为空，重新从输入栈中导过来
        if (outputStack.empty()) {
            while (!inputStack.empty()) {
                int ele = inputStack.pop();
                outputStack.push(ele);
            }
        }
        return outputStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        // 输出栈为空，重新从输入栈中导过来
        if (outputStack.empty()) {
            while (!inputStack.empty()) {
                int ele = inputStack.pop();
                outputStack.push(ele);
            }
        }
        return outputStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inputStack.empty() && outputStack.empty();
    }
}
