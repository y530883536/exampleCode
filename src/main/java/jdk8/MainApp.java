package jdk8;

import io.lettuce.core.output.KeyStreamingChannel;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
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
        strList.add("ycf");

        Consumer<String> sayNormal = user::sayNormal;
        strList.forEach(sayNormal);

        //这里调用静态方法，User是大写
        Consumer<String> sayStatic = User::sayStatic;
        strList.forEach(sayStatic);

        //这种有返回值的方法不是组装成一个Consumer对象，而是一个Function对象
        //至于Function现在要怎么使用，暂时还不清楚
        Function<String, String> getWish = user::getWish;

        Supplier<String> supplier = String::new;
        System.out.println("supplier" + supplier.get());
    }
}
