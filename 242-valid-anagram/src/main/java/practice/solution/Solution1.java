package practice.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Vander
 * @date :   2021/2/20
 * @description : 暴力遍历，记录每个字母的出现次数，再判断两个集合是否相等
 */
public class Solution1 {

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = stringCharMap(s);
        Map<Character, Integer> tMap = stringCharMap(t);

        if(sMap.size() != tMap.size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            if (tMap.containsKey(entry.getKey())) {
                if(entry.getValue().intValue() != tMap.get(entry.getKey()).intValue()) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> stringCharMap(String string) {
        char[] chars = string.toCharArray();
        Map<Character, Integer> stringMap = new HashMap<>();
        for (char c : chars) {
            if (stringMap.containsKey(c)) {
                stringMap.put(c, stringMap.get(c) + 1);
            } else {
                stringMap.put(c, 1);
            }
        }
        return stringMap;
    }

}
