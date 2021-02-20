package practice;

import practice.solution.Solution1;

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

        s = "a";
        t = "b";
        System.out.println(solution1.isAnagram(s, t));

    }

}
