package ycf.zero.local.designPattern.bridge.self;

public class MainApp {
    public static void main(String[] args) {
        Brand apple = new Apple();
        Brand HuaWei = new HuaWei();
        Brand XiaoMi = new XiaoMi();
        DigitalProduct computer = new Computer(apple);
        computer.brandName();
        computer.feature();
        DigitalProduct mobile = new Mobile(HuaWei);
        mobile.brandName();
        mobile.feature();
        DigitalProduct laptop = new Laptop(XiaoMi);
        laptop.brandName();
        laptop.feature();
    }
}
