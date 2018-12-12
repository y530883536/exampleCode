package basic;

/**
 * @author yechangfeng
 * @date 2018/12/12
 */
public class UncertainParams {
    public static void test(String... args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }

    public static void main(String[] args) {
        String[] strs = {"dsa","dssdd","asdsa","ppp"};
        UncertainParams.test("jugg","ds","alchemist","am","tb");
        UncertainParams.test(strs);
    }
}
