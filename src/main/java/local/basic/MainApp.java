package local.basic;

import java.util.*;

/**
 * 这个类是测试代码的地方，记得及时清掉测试过代码，并且不要删除这个类
 * @author yechangfeng
 * @date 2018/12/20
 */
public class MainApp {
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("fuck");
        list.add("you");
        String join = String.join(",", list);
        System.out.println(join);
        StringJoiner joiner = new StringJoiner("-");
        joiner.add("fuck").add("you").add("hello");
        System.out.println(joiner.toString());
    }
}
