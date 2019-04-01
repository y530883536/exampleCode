package ycf.zero.local.classLoader;

/**
 * @author yechangfeng
 * @date 2019/1/2
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader app = ClassLoader.getSystemClassLoader();
        System.out.println(app);
        ClassLoader ext = app.getParent();
        System.out.println(ext);
        ClassLoader bootstrap = ext.getParent();
        //bootstrap就是null了
        System.out.println(bootstrap);
        //ClassLoader what = bootstrap.getParent();
        //System.out.println(what);

        //这里和ClassLoader.getSystemClassLoader()拿到的是同一个AppClassLoader的对象
        System.out.println(Thread.currentThread().getContextClassLoader());
    }
}
