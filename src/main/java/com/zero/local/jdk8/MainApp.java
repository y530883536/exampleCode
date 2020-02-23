package com.zero.local.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
* 函数式编程就是传的参数是一个方法，目前在JDK中的应用是一个数组里的元素都要用某个方法去执行
*/
public class MainApp {
    public static void main(String[] args) {
        User user = new User();
        List<String> strList = new ArrayList<>(10);
        strList.add("tom");
        strList.add("jack");
        strList.add("com");

        Consumer<String> sayNormal = user::sayNormal;
        strList.forEach(sayNormal);
        //上下两个等价
        for (String str : strList) {
            user.sayNormal(str);
        }
        //这里调用静态方法，User是大写
        Consumer<String> sayStatic = User::sayStatic;
        strList.forEach(sayStatic);

        Function<String, String> getWish = user::getWish;
        String applyStr = getWish.apply("豪哥");
        //上下两个等价
        String wishStr = user.getWish("豪哥");
        System.out.println(applyStr);
        System.out.println(wishStr);

        Predicate<Integer> predicate = user::isBig;
        System.out.println(predicate.test(14));
        System.out.println(predicate.test(17));

        //Supplier<String> supplier = String::new;
        Supplier<String> supplier = user::getName;
        System.out.println("supplier:" + supplier.get());

        Integer ii = new Integer("34");
        Supplier<Integer> supplier1 = ii::intValue;
        System.out.println(supplier1.get());
    }
}
