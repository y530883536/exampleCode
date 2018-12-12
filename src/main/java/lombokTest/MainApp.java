package lombokTest;

import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yechangfeng
 * @date 2018/12/10
 */
public class MainApp {
    public static void main(String[] args) {
        Person person1 = new Person("ycf",28,"china","男");
        Person person2 = new Person("ycf",28,"liquid","男");
        person1.setAddress("liquid");
        System.out.println(person1.getAddress());
        System.out.println(person1);
        System.out.println(person1.equals(person2));
        Test test1 = new Test();
        test1.setTestField("aaa");
        Test test2 = new Test();
        test2.setTestField("aaa");
        System.out.println(test1.hashCode());
        System.out.println(test2.hashCode());
        System.out.println(test1.equals(test2));
        System.out.println(RequestMethod.POST.name().equals("POST"));
    }
}
