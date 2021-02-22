import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : Vander
 * @date :   2021/2/21
 * @description :
 */
public class HashSetTest {

    @Test
    public void test1() {
        Set<Set<Integer>> sets = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(1);
        set2.add(3);
        sets.add(set1);
        sets.add(set2);

        System.out.println(sets);
    }

    @Test
    public void test2() {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        set.add(list1);
        set.add(list2);
        System.out.println(set);
    }

}
