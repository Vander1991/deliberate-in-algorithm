package practice.solution;

import java.util.*;

/**
 * @author : Vander
 * @date :   2021/2/17
 * @description :
 */
public class Solution1 {

    public static boolean isValid(String s) {
        Map<Character, Character> pairs = initPairs();
        List<Character> leftParentheses = Arrays.asList(new Character[]{'(', '[' , '{'});
        // 存放先入栈的左括号
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 左括号则入栈，右括号则将栈顶元素与之匹配，匹配不上返回false
            if (leftParentheses.contains(chars[i])) {
                stack.push(chars[i]);
            } else {
                if (stack.empty() || !pairs.get(stack.pop()).equals(chars[i])) {
                    return false;
                }
            }
        }
        // 若最后堆栈还有，说明没有匹配完
        if(!stack.empty()) {
            return false;
        }

        return true;
    }

    private static Map<Character, Character> initPairs() {
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('{', '}');
        pairs.put('[', ']');
        pairs.put('(', ')');
        return pairs;
    }


}
