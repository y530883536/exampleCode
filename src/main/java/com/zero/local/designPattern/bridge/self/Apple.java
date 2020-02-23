package com.zero.local.designPattern.bridge.self;

public class Apple implements Brand {
    @Override
    public void brandName() {
        System.out.println("苹果");
    }
}
