package ycf.zero.local.designPattern.proxy.staticProxy;

public class MansionHouseOwner implements HouseOwner{
    @Override
    public void rentHouse() {
        System.out.println("房东：豪宅出租ing");
    }
}
