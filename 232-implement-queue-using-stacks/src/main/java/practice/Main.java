package practice;

import practice.solution.MyQueue1;
import practice.solution.MyQueue2;

/**
 * @author : Vander
 * @date :   2021/2/18
 * @description :
 */
public class Main {

    public static void main(String[] args) {
        MyQueue1 queue = new MyQueue1();
        queue.push(1);
        queue.push(2);
        int result1 = queue.pop();
        int result2 = queue.peek();
        boolean result3 = queue.empty();
        System.out.println();
        // 官方实现
        MyQueue2 queue2 = new MyQueue2();
        queue2.push(1);
        queue2.push(2);
        int result4 = queue2.pop();
        int result5 = queue2.peek();
        boolean result6 = queue2.empty();
        System.out.println();
    }

}
