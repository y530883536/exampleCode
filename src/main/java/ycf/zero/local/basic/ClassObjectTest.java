package ycf.zero.local.basic;

class Test{
    static{
        System.out.println("hello");
    }
}

public class ClassObjectTest {
    public static void main(String[] args) throws Exception{
        //Class<Test> clazz = Class.forName("basic.Test");       //Class.forName的情况静态代码块会执行
        Class<Test> clazz = Test.class;                          //Test.class的情况下静态代码块不会执行
        System.out.println(clazz.getName());
    }

}
