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
        Arrays.sort(nums);
        Map<Integer, Integer> numbersMap = getNumbersMap(nums);
        Set<List<Integer>> tempResults = new HashSet<>();

        int numsLen = nums.length;
        for (int i = 0; i < numsLen - 2; i++) {
            for (int j = i + 1; j < numsLen - 1; j++) {
                // 遍历到与前一个元素相同直接跳过，因为前一个元素已经跟别的元素组合过了
                if ((i > 0 && nums[i] == nums[i - 1])) {
                    continue;
                }

                int another = -(nums[i] + nums[j]);

                // 对连续3个0的情况做特殊处理
                if (0 == another && 0 == nums[i] && 0 == nums[i + 2]) {
                    tempResults.add(addElements(nums, i, j));
                }

                // 检查两数之和是否在hash表中
                if (numbersMap.containsKey(another)) {
                    int targetIndex = numbersMap.get(another);
                    if(targetIndex <= j) {// 往回找了，前面肯定已经组合过了 或 目标数就是nums[j]本身
                        continue;
                    }
                    tempResults.add(addElements(nums, i, j));
                }
            }
        }

        // 将临时结果集的结果添加到results
        for (List<Integer> list : tempResults) {
            results.add(list);
        }

        return results;
    }

    private Map<Integer, Integer> getNumbersMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        return map;
    }

    private List<Integer> addElements(int[] nums, int i, int j) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[i]);
        list.add(nums[j]);
        list.add(-(nums[i] + nums[j]));
        list.sort(new ComparatorImpl());
        return list;
    }

    class ComparatorImpl implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 > o2) {
                return 1;
            } else if (o1 < o2) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}
