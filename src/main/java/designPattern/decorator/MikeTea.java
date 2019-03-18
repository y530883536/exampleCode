package designPattern.decorator;

public class MikeTea implements Eatable {
    @Override
    public void flavor() {
        System.out.print("奶茶");
    }
}
