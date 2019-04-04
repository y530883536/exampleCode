package com.zero.local.basic;

public class NumberConstant {
    public static void main(String[] args) {
        Integer i1 = 5;
        Integer i2 = Integer.valueOf("5");
        //Integer i3 = new Integer("5");        //用new不会使用常量池
        System.out.println(i1 == i2);           //true

        Byte b1 = 127;
        Byte b2 = 127;
        System.out.println(b1 == b2);           //true;byte的范围正好是-128~127，所以个人推测其他几个基本类型是以byte的范围为标准的


        Short s1 = 128;
        Short s2 = 128;
        System.out.println(s1 == s2);

        Long l1 = 128l;
        Long l2 = 128l;
        System.out.println(l1 == l2);

        Boolean bb1 = false;
        Boolean bb2 = false;
        System.out.println(bb1 == bb2);

        Double d1 = 127.0;
        Double d2 = 127.0;
        System.out.println(d1 == d2);


    }
}
