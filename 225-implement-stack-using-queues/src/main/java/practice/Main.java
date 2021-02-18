package practice;

import practice.solution.MyStack1;

/**
 * @author : Vander
 * @date :   2021/2/18
 * @description :
 */
public class Main {

    public static void main(String[] args) {
        MyStack1 stack = new MyStack1();
        stack.push(1);
        stack.push(2);
        int result1 = stack.pop();// 2
        int result2 = stack.top();// 1
        boolean result3 = stack.empty(); // false
        System.out.println();
    }

}
