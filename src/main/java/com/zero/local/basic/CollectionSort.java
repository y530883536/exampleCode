package com.zero.local.basic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CollectionSort {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(4);
        intList.add(7);
        intList.add(1);
        intList.add(9);
        intList.add(3);
        intList.add(-8);
        intList.add(10);
        //最原始的写法，也是个人感觉可读性最好的写法
        intList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //三种实现方式
                //return o1-o2;
                //return o1.compareTo(o2);
                return Integer.compare(o1,o2);
            }
        });

        //lambda
        intList.sort((Integer o1, Integer o2) -> {return o1-o2;});

        //这种应该是和Stream相关的写法（因为它至只有comparingInt，comparingLong和comparingDouble这三种基本类型的，感觉和Stream是有奸情的）
        //我不希望在代码中看到这种写法，可读性差得一逼
        intList.sort(Comparator.comparingInt(Integer::intValue));

        intList.forEach(i -> System.out.println(i));
    }
}
