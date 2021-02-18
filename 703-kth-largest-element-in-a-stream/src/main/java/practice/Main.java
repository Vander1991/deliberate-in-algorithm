package practice;

import practice.solution.KthLargest;

/**
 * @author : Vander
 * @date :   2021/2/18
 * @description :
 */
public class Main {

    public static void main(String[] args){
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }

}
