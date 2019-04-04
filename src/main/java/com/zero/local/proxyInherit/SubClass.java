package com.zero.local.proxyInherit;

/**
 * @author yechangfeng
 * @date 2018/12/10
 */
public class SubClass implements SuperInterface{
    @Override
    @TestAnnotation("com")
    public void sayHell() {
        System.out.println();
    }
}
