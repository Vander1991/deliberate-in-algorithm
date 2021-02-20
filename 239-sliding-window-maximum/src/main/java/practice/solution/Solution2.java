package practice.solution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : Vander
 * @date :   2021/2/19
 * @description : 使用双端队列，从左边开始一个个入队，将max左边的数，往左边全部出队（自行实现 超出实现限制）思路太复杂
 */
public class Solution2 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 判断是否为空
        if (null == nums) {
            return null;
        }
        int[] resultArray = new int[nums.length - k + 1];
        int maxIndex = 0;
        Deque<Node> deque = new LinkedList<>();
        // 先入队k个元素
        for (int i = 0; i < k; i++) {
            if (nums[i] >= nums[maxIndex]) {
                maxIndex = i;
                // 出队左侧的所有元素，计算从maxIndex到window左侧的距离
                for (int j = i + 1 - k; j < maxIndex - 1; j++) {
                    deque.pollLast();
                }
            }
            if (i >= maxIndex) {
                deque.push(new Node(i, nums[i]));
            }
        }
        resultArray[0] = nums[maxIndex];

        // i 为窗的右侧， i - k + 1 为窗的左侧
        for (int i = k, r = 1; i < nums.length; i++, r++) {
            deque.push(new Node(i, nums[i]));
            // 踢出最大值左侧的元素
            int lastIndex = deque.getLast().index;
            if (deque.getLast().index < maxIndex) {
                // 出队左侧的所有元素，计算从maxIndex到window左侧的距离
                for (int j = 0; j < maxIndex - lastIndex; j++) {
                    deque.pollLast();
                }
            }

            if (nums[i] >= nums[maxIndex]) {
                // 记录max的下标
                maxIndex = i;
            } else {
                if (maxIndex < (i - k + 1)) { // 说明maxIndex已经跑到窗口外面了，需要重新选出新的maxIndex
                    // 从队列中移除maxIndex
                    deque.pollLast();
                    maxIndex = i - k + 1;
                    // 重新找出最大的maxIndex
                    for (int t = 0; t < deque.size(); t++) {
                        Node curNode = ((LinkedList<Node>) deque).get(t);
                        if (curNode.value >= nums[maxIndex]) {
                            maxIndex = curNode.index;
                        }
                    }
                }
            }
            resultArray[r] = nums[maxIndex];
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

}
