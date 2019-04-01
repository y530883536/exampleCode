package ycf.zero.local.designPattern.proxy.staticProxy;

public class MainApp {
    public static void main(String[] args) {
        HouseOwner mansionHouseOwner = new MansionHouseOwner();

        //mansionHouseOwner.rentHouse();

        HouseOwner houseProxy = new HouseProxy(mansionHouseOwner);
        houseProxy.rentHouse();
    }
}
