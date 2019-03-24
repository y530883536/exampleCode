package designPattern.decorator;

public class Decorator implements Weapon{
    private Weapon weapon;

    public Decorator(Weapon weapon){
        this.weapon = weapon;
    }

    @Override
    public void ability() {
        weapon.ability();
    }
}
