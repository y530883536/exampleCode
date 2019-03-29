package local.designPattern.proxy.dynamicProxy.cglibProxy;

public class MainApp {
    public static void main(String[] args) {
        HouseOwner houseOwner = new MansionHouseOwner();
        CglibInterceptor cg = new CglibInterceptor(houseOwner);
        HouseOwner houseProxy = (HouseOwner)cg.getProxy();
        System.out.println("----" + houseProxy);
        houseProxy.rentHouse();
    }
}
