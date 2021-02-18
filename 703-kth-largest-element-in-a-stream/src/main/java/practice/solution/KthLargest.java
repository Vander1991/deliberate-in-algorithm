package practice.solution;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author : Vander
 * @date :   2021/2/18
 * @description : 返回第 K 大的元素（非原生想法，原生想法估计会用快排来维护k个元素的数组）
 */
public class KthLargest {

    private PriorityQueue<Integer> priorityQueue;

    private int k;

    public KthLargest(int k, int[] nums) {
        priorityQueue = new PriorityQueue<>(k, new ComparatorImpl());
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if(priorityQueue.size() >= k) {
            // 拿出小顶堆中最小的数，即堆顶
            if(val > priorityQueue.peek()) {
                // 新加入的数大于堆顶元素，则移除堆顶，重新把val加入
                priorityQueue.poll();
                priorityQueue.add(val);
            }
        } else {
            priorityQueue.add(val);
        }
        return priorityQueue.peek();
    }

    public static class ComparatorImpl implements Comparator<Integer> {
        @Override
        public int compare(Integer num1, Integer num2) {
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}