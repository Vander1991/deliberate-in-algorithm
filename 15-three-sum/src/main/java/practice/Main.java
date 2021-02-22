package practice;

import practice.solution.Solution1;
import practice.solution.Solution2;

/**
 * @author : Vander
 * @date :   2021/2/21
 * @description :
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, -2, 0, 0, 2, 2, 4};
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.threeSum(nums));

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.threeSum(nums));


        nums = new int[]{0, 0, 0};
        System.out.println(solution1.threeSum(nums));
        System.out.println(solution2.threeSum(nums));

        nums = new int[]{1, 2, -2, -1};
        System.out.println(solution1.threeSum(nums));
        System.out.println(solution2.threeSum(nums));

        nums = new int[]{1, 1, -2};
        System.out.println(solution1.threeSum(nums));
        System.out.println(solution2.threeSum(nums));
    }


}
