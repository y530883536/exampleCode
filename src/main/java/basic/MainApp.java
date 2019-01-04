package basic;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author yechangfeng
 * @date 2018/12/20
 */
public class MainApp {
    public static void main(String[] args) {
        //System.out.println(SexEnum.MALE.getValue());
        String str = "01020304";
        String house = str.substring(0,2);
        String unit = str.substring(2,4);
        String room = str.substring(4,8);
        System.out.println(house);
        System.out.println(unit);
        System.out.println(room);
        Integer i = Integer.parseInt("02");
        System.out.println(i);
        String a = "1234567891123";
        Integer ii = Integer.parseInt(a);
        System.out.println(ii);
        //Date没有接收BigInteger参数的方法
        //Date date = new Date(new BigInteger("9223372036854775807"));
    }
}
