package proxyInherit;

/**
 * @author yechangfeng
 * @date 2018/12/10
 */
public class SubClass implements SuperInterface{
    @Override
    @TestAnnotation("ycf")
    public void sayHell() {
        System.out.println();
    }
}
