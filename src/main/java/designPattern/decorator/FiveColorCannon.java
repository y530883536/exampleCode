package designPattern.decorator;

public class FiveColorCannon extends Decorator{

    public FiveColorCannon(Weapon weapon){
        super(weapon);
    }

    @Override
    public void ability() {
        super.ability();
        System.out.println("五彩大炮来削人棍了");
    }
}
