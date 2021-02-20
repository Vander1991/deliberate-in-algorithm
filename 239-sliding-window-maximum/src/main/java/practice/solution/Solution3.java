package practice.solution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : Vander
 * @date :   2021/2/20
 * @description : 官方实现-使用双端队列
 */
public class Solution3 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; ++i) {
            // 遍历到右侧的数比左侧大，所以左侧不可能当老大了，则将左侧的移除
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);// 相当于加入到最大元素的右侧（右侧是队尾，左侧是队头）
        }

        int[] ans = new int[n - k + 1];
        // 队列最左侧即为最大数的下标
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            // 遍历到右侧的数比左侧大，所以左侧不可能当老大了，则将左侧的移除
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // 如果队头已经出了窗口，则将队头移除，队头永远是最大的
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

}
