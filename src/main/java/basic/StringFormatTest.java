package basic;

/**
 * @author yechangfeng
 * @date 2019/1/9
 */
public class StringFormatTest {
    public static void main(String[] args) {
        String str1 = String.format("you are a %s man", "fucking");
        System.out.println(str1);

        String str2 = "hello/world/fuck\\you\\man";
        String[] split = str2.split("/|\\\\");
        System.out.println(str2);
        System.out.println("aaa");
    }
}
