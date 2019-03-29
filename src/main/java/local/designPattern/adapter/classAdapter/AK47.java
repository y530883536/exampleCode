package local.designPattern.adapter.classAdapter;

public class AK47 implements Gun {

    @Override
    public void fire() {
        System.out.println("762子弹");
    }
}
