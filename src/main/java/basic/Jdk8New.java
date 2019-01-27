package basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Jdk8New {
    public static void main(String[] args) throws Exception{
        List<String> strList1 = new ArrayList<>();
        strList1.add("a");
        strList1.add("b");
        strList1.add("c");
        //lambda表达式的写法 (参数) -> {代码}
        //strList1.forEach((str) -> System.out.println(str));
        //上面这句的更简略写法，但是感觉会被人打死
        strList1.forEach(System.out::println);
        System.out.println("-----------------------");

        //将字母变成大写
        List<String> strList2 = new ArrayList<>();
        strList2.add("fuck");
        strList2.add("you");
        strList2.add("man");
        List<String> result1 = strList2.stream().map(String::toUpperCase).collect(Collectors.toList());
        result1.forEach(str -> System.out.println(str));
        System.out.println("-----------------------");

        //将数字变成平方
        List<Integer> intList1 = new ArrayList<>();
        intList1.add(4);
        intList1.add(6);
        intList1.add(8);
        List<Integer> result2 = intList1.stream().map(n -> n * 2).collect(Collectors.toList());
        result2.forEach(i -> System.out.println(i));
        System.out.println("-----------------------");

        //将一片文章里面所有的单词存进一个List中
        BufferedReader br = new BufferedReader(new FileReader("D:/article.txt"));
        List<String> result3 = br.lines().flatMap(line -> Stream.of(line.split(" |[.]|,"))).collect(Collectors.toList());
        System.out.println("cao");
    }
}
