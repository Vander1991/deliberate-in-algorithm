package practice;

import practice.solution.Solution1;
import practice.solution.Solution2;
import practice.solution.Solution3;

/**
 * @author : Vander
 * @date :   2021/2/19
 * @description :
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, 4, 6, 7};
        Solution1 solution1 = new Solution1();
        for (int i : solution1.maxSlidingWindow(nums, 3)) {
            System.out.print(i + " ");
        }
        System.out.println();

        Solution2 solution2 = new Solution2();
        for (int i : solution2.maxSlidingWindow(nums, 3)) {
            System.out.print(i + " ");
        }
        System.out.println();

        Solution3 solution3 = new Solution3();
        for (int i : solution3.maxSlidingWindow(nums, 3)) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

}
