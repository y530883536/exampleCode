package basic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 这个类是测试代码的地方，记得及时清掉测试过代码，并且不要删除这个类
 * @author yechangfeng
 * @date 2018/12/20
 */
public class MainApp {
    public static void main(String[] args) throws Exception {
        Set<Person> set = new HashSet<>();
        Person p1 = new Person("111");
        Person p2 = new Person("222");
        set.add(p1);
        set.add(p2);
        p1.setName("444");              //这个地方改了p1的name的值，结果是p1永远也remove不了
        set.remove(p1);
        System.out.println(set.size()); //size还是2
        List<String> strList = new ArrayList<>();
        strList.add("asd");
        strList.add("aasd");
        strList.add("aaasd");
        for (String str : strList) {
            str.replaceAll("a", "f");
        }
        System.out.println(strList);
    }
}

class Person{
    private String name;

    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Person)){
            return false;
        }
        Person person = (Person)obj;
        return person.name.equals(this.name);
    }
}