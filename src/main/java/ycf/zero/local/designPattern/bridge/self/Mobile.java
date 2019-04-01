package ycf.zero.local.designPattern.bridge.self;

public class Mobile extends DigitalProduct {

    public Mobile(Brand brand){
        super(brand);
    }

    @Override
    public void feature() {
        System.out.println("便携移动");
    }

}
