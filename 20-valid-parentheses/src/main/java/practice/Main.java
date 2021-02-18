package practice;


import practice.solution.Solution1;

/**
 * @author : Vander
 * @date :   2021/2/8
 * @description :
 */
public class Main {

    public static void main(String[] args) {
        String s = "[]{}())";
        System.out.println("\"" + s + "\" isValid : " + Solution1.isValid(s));
    }

}
