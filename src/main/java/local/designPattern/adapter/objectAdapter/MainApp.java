package local.designPattern.adapter.objectAdapter;

public class MainApp {
    public static void main(String[] args) {
        Adapter adapter = new Adapter(new AK47());
        adapter.chop();
    }
}
