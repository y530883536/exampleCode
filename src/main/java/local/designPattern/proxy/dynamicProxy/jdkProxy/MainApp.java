package local.designPattern.proxy.dynamicProxy.jdkProxy;

public class MainApp {
    public static void main(String[] args) {
        HouseOwner houseOwner = new MansionHouseOwner();
        JdkHandler jdkHandler = new JdkHandler(houseOwner);
        HouseOwner houseProxy = (HouseOwner)jdkHandler.getProxy();
        System.out.println(houseProxy);
        houseProxy.rentHouse();
        houseProxy.test();
    }
}
