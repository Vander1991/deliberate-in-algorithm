package practice;

import practice.solution.Solution1;
import practice.solution.Solution2;
import practice.solution.Solution3;

/**
 * @author : Vander
 * @date :   2021/2/20
 * @description :
 */
public class Main {

    public static void main(String[] args){
        String s = "dgqztusjuu", t = "dqugjzutsu";
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.isAnagram(s, t));

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.isAnagram(s, t));

        Solution3 solution3 = new Solution3();
        System.out.println(solution3.isAnagram(s, t));

        s = "a";
        t = "b";
        System.out.println(solution1.isAnagram(s, t));
        System.out.println(solution2.isAnagram(s, t));
        System.out.println(solution3.isAnagram(s, t));
    }

}
