import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Vander
 * @date :   2021/2/21
 * @description :
 */
public class HashSetTest {

    @Test
    public void test() {
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

}
