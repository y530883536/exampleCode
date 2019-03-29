package local.basic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yechangfeng
 * @date 2018/12/19
 */
public class CollectionContainTest {
    public static void main(String[] args) {
        List<BigInteger> list1 = new ArrayList<>();
        list1.add(new BigInteger("1"));
        list1.add(new BigInteger("2"));
        list1.add(new BigInteger("3"));
        boolean b1 = list1.contains(new BigInteger("1"));
        boolean b2 = list1.contains(new BigInteger("4"));
        System.out.println(b1);
        System.out.println(b2);

        List<BigInteger> list2 = new ArrayList<>();
        list2.add(new BigInteger("1"));
        list2.add(new BigInteger("4"));
        System.out.println(list1.containsAll(list2));
        System.out.println(System.currentTimeMillis());

        List<String> list3 = new ArrayList<>();
        List<String> list4 = null;
        list3.addAll(list4);
    }
}
