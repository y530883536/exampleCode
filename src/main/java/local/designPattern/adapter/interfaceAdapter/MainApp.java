package local.designPattern.adapter.interfaceAdapter;

public class MainApp {
    public static void main(String[] args) {
        TestInterface t = new AdapterImpl();
        t.a();
        t.b();
        t.c();
        t.d();
    }
}
