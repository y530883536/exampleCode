package local.designPattern.adapter.classAdapter;

public class Adapter extends AK47 implements Saber {
    @Override
    public void chop() {
        fire();
    }
}
