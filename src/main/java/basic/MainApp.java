package basic;

/**
 * 这个类是测试代码的地方，记得及时清掉测试过代码，并且不要删除这个类
 * @author yechangfeng
 * @date 2018/12/20
 */
public class MainApp {
    public static void main(String[] args) throws Exception {
        TestGeneric<Integer> tg = new TestGeneric<>();
        tg.setObject(13);
        tg.greet();
    }

}
