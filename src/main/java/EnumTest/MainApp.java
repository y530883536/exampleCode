package EnumTest;

/**
 * @author yechangfeng
 * @date 2018/12/10
 */
public class MainApp {
    public static void main(String[] args) {
        System.out.println(DeviceStateEnum.ONLINE.getName());
        System.out.println(DeviceStateEnum.OFFLINE.getValue());
    }
}
