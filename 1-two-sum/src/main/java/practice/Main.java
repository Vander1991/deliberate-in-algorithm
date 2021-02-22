package practice;

import practice.solution.Solution1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Vander
 * @date :   2021/2/21
 * @description :
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        Solution1 solution1 = new Solution1();
        int[] results = solution1.twoSum(nums, target);
        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i] + " ");
        }
        System.out.println();

        nums = new int[]{3, 3};
        target = 6;
        results = solution1.twoSum(nums, target);
        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i] + " ");
        }

    }

}
