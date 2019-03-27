package designPattern.bridge.self;

public class Computer extends DigitalProduct {

    public Computer(Brand brand){
        super(brand);
    }

    @Override
    public void feature() {
        System.out.println("工作和娱乐重器");
    }

}
