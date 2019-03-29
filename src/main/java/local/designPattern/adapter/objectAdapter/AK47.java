package local.designPattern.adapter.objectAdapter;

public class AK47 implements Gun {

    @Override
    public void fire() {
        System.out.println("762子弹");
    }
}
