package basic;

/**
 * @author yechangfeng
 * @date 2018/12/20
 */
public class MainApp {
    public static void main(String[] args) {
        System.out.println(SexEnum.MALE.getValue());
        String str = "01020304";
        String house = str.substring(0,2);
        String unit = str.substring(2,4);
        String room = str.substring(4,8);
        System.out.println(house);
        System.out.println(unit);
        System.out.println(room);
    }
}
