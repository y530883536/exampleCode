package ycf.zero.local.designPattern.proxy.dynamicProxy.jdkProxy;

public class MansionHouseOwner implements HouseOwner {

    @Override
    public void rentHouse() {
        System.out.println("房东：豪宅出租ing");
    }

    @Override
    public void test() {
        System.out.println("ycf/zero/local/test");
    }
}
