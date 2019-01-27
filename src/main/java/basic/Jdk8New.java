package basic;

import java.util.ArrayList;
import java.util.List;

public class Jdk8New {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        strList.add("a");
        strList.add("b");
        strList.add("c");
        //lambda表达式的写法 (参数) -> {代码}
        strList.forEach((str) -> {
            System.out.println("fuck");
            System.out.println(str);
        });
    }
}
