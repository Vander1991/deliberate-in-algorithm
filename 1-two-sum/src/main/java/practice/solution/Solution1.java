package practice.solution;

import java.util.HashMap;

/**
 * @author : Vander
 * @date :   2021/2/21
 * @description :
 */
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] results = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                results[0] = hashMap.get(target - nums[i]);
                results[1] = i;
                return results;
            }
            hashMap.put(target - nums[i], null);
            hashMap.put(nums[i], i);
        }
        return null;
    }

}
