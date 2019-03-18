package designPattern.decorator;

public class MainApp {
    public static void main(String[] args) {
        Eatable mikeTea = new MikeTea();
        mikeTea.flavor();
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("----------------------------");
        Eatable combineMikeTea = new Condiment(new Pudding(new Chocolate(mikeTea)));
        combineMikeTea.flavor();
        System.out.println();
    }
}
