package reflection;

/**
 * @author yechangfeng
 * @date 2019/1/3
 */
public class TestObject {
    public void sayNoParam(){
        System.out.println("fuck");
    }

    public void sayWithParam(String str){
        System.out.println(str);
    }

    public String getValue(){
        return "8hours";
    }

    public static void sayStatic(){
        System.out.println("50oneYear");
    }
}
