package practice.solution;

import java.util.Arrays;

/**
 * @author : Vander
 * @date :   2021/2/21
 * @description : 类似于Hash表的实现方式，构建数组，将0-25个位置存放26个小写字母出现的次数
 */
public class Solution3 {

    public boolean isAnagram(String s, String t) {
        int[] sCharStorage = getCharStorage(s);
        int[] tCharStorage = getCharStorage(t);
        if (Arrays.equals(sCharStorage, tCharStorage)) {
            return true;
        }
        return false;
    }

    public int[] getCharStorage(String string) {
        int[] charStorage = new int[26];
        for (char letter : string.toCharArray()) {
            charStorage[letter - 'a'] = charStorage[letter - 'a'] + 1;
        }
        return charStorage;
    }

}
