package com.zero.local.designPattern.bridge.self;

public class Laptop extends DigitalProduct {

    public Laptop(Brand brand) {
        super(brand);
    }

    @Override
    public void brandName() {
        super.brandName();
    }

    @Override
    public void feature() {
        System.out.println("建议便携和办公");
    }
}
