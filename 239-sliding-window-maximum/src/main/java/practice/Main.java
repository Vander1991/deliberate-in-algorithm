package practice;

import practice.solution.Solution1;

/**
 * @author : Vander
 * @date :   2021/2/19
 * @description :
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{1, -1};
        Solution1 solution1 = new Solution1();
        for (int i : solution1.maxSlidingWindow(nums, 1)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
