package practice.solution;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author : Vander
 * @date :   2021/2/19
 * @description : 使用大顶堆来完成，若栈顶元素不在队列里，则不断的移除栈顶元素（非自己想出来的）
 */
public class Solution1 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] resultArray = new int[nums.length - k + 1];
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new ComparatorImpl());
        // 首次添加元素
        for (int i = 0; i < k; i++) {
            priorityQueue.add(new Node(i, nums[i]));
        }
        resultArray[0] = priorityQueue.peek().value;

        for (int i = k, j = 1; i < nums.length; i++, j++) {
            // 判断栈顶元素是否已经出了窗口
            while (!priorityQueue.isEmpty() && priorityQueue.peek().index < (i - k + 1)) {
                priorityQueue.poll();
            }
            priorityQueue.add(new Node(i, nums[i]));
            resultArray[j] = priorityQueue.peek().value;
        }
        return resultArray;
    }

    class Node {

        int index;
        int value;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

    }

    class ComparatorImpl implements Comparator<Node> {
        @Override
        public int compare(Node node1, Node node2) {
            if (node1.value > node2.value) {
                return -1;
            } else if (node1.value < node2.value) {
                return 1;
            } else {
                return 0;
            }
        }
    }

}