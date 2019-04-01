package ycf.zero.local.jdk8;

import java.util.function.Function;

public class FunctionTest {
    public void greet(Function<Integer,String> function,Integer length){
        System.out.println("你的尺寸：" + function.apply(length));
    }

    public static void main(String[] args) {
        FunctionTest test = new FunctionTest();
        Dick dick = new Dick();
        test.greet(dick::size,19);
    }
}

class Dick {

    public String size(int length){
        if(length < 15){
            return "给平均水平丢人了";
        }else{
            return "ass♂we♂can";
        }
    }
}
