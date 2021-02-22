package practice.solution;

import java.util.*;

/**
 * @author : Vander
 * @date :   2021/2/21
 * @description : 我的做法暴力遍历：运行结果超出时间限制，前期虽然想到用map来替代第三层循环，但是考虑到元素会被重复利用的问题，所以放弃了
 * 解决方式：重复处理可以记录哪些是重复出现的，解决重复数据的思路复杂，细节较多
 * 解决重复：先进行排序
 */
public class Solution1 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length < 3) {
            return results;
        }
        Map<Integer, Integer> numbersMap = getNumbersMap(nums);
        List<List<Integer>> tempResults = new ArrayList<>();

        int numsLen = nums.length;
        for (int i = 0; i < numsLen - 2; i++) {
            for (int j = i + 1; j < numsLen - 1; j++) {
                int another = -(nums[i] + nums[j]);
                if (numbersMap.containsKey(another)) {
                    if (0 == another && 0 == nums[i] && 0 == nums[j]) {
                        if (numbersMap.get(another) >= 3) {
                            tempResults.add(addElements(nums, i, j));
                            continue;
                        } else {
                            continue;
                        }
                    }

                    if (nums[i] == another || nums[j] == another) {
                        if (numbersMap.get(another) >= 2) {
                            tempResults.add(addElements(nums, i, j));
                        } else {
                            continue;
                        }
                    } else {
                        tempResults.add(addElements(nums, i, j));
                    }
                }
            }
        }

        return results;
    }

    private Map<Integer, Integer> getNumbersMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }

    private List<Integer> addElements(int[] nums, int i, int j) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[i]);
        list.add(nums[j]);
        list.add(-(nums[i] + nums[j]));
        return list;
    }

}
