package designPattern.decorator;

public class Condiment implements Eatable {
    private Eatable eatable;

    public Condiment(Eatable eatable){
        this.eatable = eatable;
    }

    @Override
    public void flavor() {
        eatable.flavor();
    }
}
