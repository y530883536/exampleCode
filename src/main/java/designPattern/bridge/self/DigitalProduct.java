package designPattern.bridge.self;

public abstract class DigitalProduct {

    private Brand brand;

    public DigitalProduct(Brand brand){
        this.brand = brand;
    }

    public void brandName(){
        brand.brandName();
    }

    public abstract void feature();

}
