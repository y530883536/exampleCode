package com.zero.local.reflection;

/**
 * @author yechangfeng
 * @date 2019/1/3
 */
public class TestInterfaceImpl implements TestInterface {

    public TestInterfaceImpl() {
    }

    public TestInterfaceImpl(String str) {
        System.out.println("init" + str);
    }

    @Override
    public void sayNoParam() {
        System.out.println("I'm curious");
    }

    @Override
    public void sayWithParam(String str) {
        System.out.println(str);
    }

    @Override
    public String getValue() {
        return "I'm 29";
    }
}
