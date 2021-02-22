package practice.solution;

import java.util.Arrays;

/**
 * @author : Vander
 * @date :   2021/2/20
 * @description :
 */
public class Solution2 {

    public boolean isAnagram(String s, String t) {
        String sortedS = sortString(s);
        String sortedT = sortString(t);
        if(sortedS.equals(sortedT)) {
            return true;
        }
        return false;
    }

    private String sortString(String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
