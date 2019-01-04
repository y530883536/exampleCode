package util;

import java.util.Date;

/**
 * @author yechangfeng
 * @date 2018/12/29
 */
public class MainApp {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("ycf");
        person.setAge(28);
        person.setGender(1);
        Student student = new Student();
        PropertyUtil.setPropertyFor(person,student);
        System.out.println("aaa");
        System.out.println(new Date().getTime());
        Date date = new Date(Long.valueOf("1546078174632"));
        System.out.println(date);
    }
}
