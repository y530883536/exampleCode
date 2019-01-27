package basic;

/**
 * Created by YCF on 2017/8/17.
 */
public class StringHashCode {
    public static void main(String[] args) {
        //ASCII码：y121,c99,g102
        //h = 31 * 0 + 121 = 121
        //h = 31 * 121 + 99 = 3850
        //h = 31 * 3850 + 102 = 119452
        System.out.println("ycf".hashCode());
    }
}
