package com.zero.local.designPattern.decorator;

public class Chocolate extends Condiment {

    public Chocolate(Eatable eatable){
        super(eatable);
    }

    @Override
    public void flavor() {
        System.out.print("巧克力");
        super.flavor();
    }
}
