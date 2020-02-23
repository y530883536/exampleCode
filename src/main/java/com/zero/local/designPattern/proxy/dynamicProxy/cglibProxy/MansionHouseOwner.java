package com.zero.local.designPattern.proxy.dynamicProxy.cglibProxy;

public class MansionHouseOwner implements HouseOwner {
    @Override
    public void rentHouse() {
        System.out.println("房东：豪宅出租ing");
    }
}
