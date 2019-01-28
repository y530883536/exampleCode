package basic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 这个类是测试代码的地方，记得及时清掉测试过代码，并且不要删除这个类
 * @author yechangfeng
 * @date 2018/12/20
 */
public class MainApp {
    public static void main(String[] args) {
        List<Integer> intList1 = new ArrayList<>();
        intList1.add(1);
        intList1.add(2);
        List<Integer> intList2 = Collections.synchronizedList(intList1);
        intList2.add(3);
        intList1.add(4);
        intList1.set(0,11);
        intList2.set(1,22);
        System.out.println(intList1);
        System.out.println(intList2);
    }
}
