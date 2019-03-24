package designPattern.proxy.staticProxy;

public class HouseProxy implements HouseOwner {

    private HouseOwner houseOwner;

    public HouseProxy(HouseOwner houseOwner){
        this.houseOwner = houseOwner;
    }

    @Override
    public void rentHouse() {
        before();
        houseOwner.rentHouse();
        after();
    }

    private void before(){
        System.out.println("proxy：中介公司开始代理租房子业务");
        System.out.println("proxy：把房子打扫干净");
        System.out.println("proxy：挂在闲鱼上");
    }

    private void after(){
        System.out.println("proxy：租出去了");
        System.out.println("proxy：跟房东和租客收佣金");
    }
}
