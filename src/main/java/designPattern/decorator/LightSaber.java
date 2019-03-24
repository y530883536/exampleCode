package designPattern.decorator;

public class LightSaber extends Decorator{

    public LightSaber(Weapon weapon){
        super(weapon);
    }

    @Override
    public void ability() {
        super.ability();
        System.out.println("40米斩舰刀");
    }
}
