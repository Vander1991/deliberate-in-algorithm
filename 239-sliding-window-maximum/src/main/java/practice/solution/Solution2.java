package practice.solution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : Vander
 * @date :   2021/2/19
 * @description : 使用双端队列，从左边开始一个个入队，将max左边的数，往左边全部出队
 */
public class Solution2 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 判断是否为空
        if (null == nums) {
            return null;
        }
        int[] resultArray = new int[nums.length - k + 1];
        int maxIndex = 0;
        Deque<Integer> deque = new LinkedList<>();
        // 先入队k个元素
        for (int i = 0; i < k; i++) {
            maxIndex = 0;
            if (nums[i] >= nums[maxIndex]) {
                maxIndex = i;
            }
            if (i >= maxIndex) {
                deque.push(nums[i]);
            }
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] >= nums[maxIndex]) {
                maxIndex = i;
            }
            // 出队左侧的所有元素，计算从maxIndex到window左侧的距离
            for (int j = i + 1 - k; j < maxIndex - 1; j++) {
                deque.pollLast();
            }
            // 能到此处的肯定都是右侧的元素
            deque.push(nums[i]);
        }
        return resultArray;
    }

}
