package designPattern.decorator;

public class MainApp {
    public static void main(String[] args) {
        Weapon weapon = new Gundom();
        weapon.ability();
        System.out.println("----------------------------");
        System.out.println("----------------------------");
        Decorator decorator4 = new Decorator(new LightSaber(new FiveColorCannon(weapon)));
        decorator4.ability();
    }
}
