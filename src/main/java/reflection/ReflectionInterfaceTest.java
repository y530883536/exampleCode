package reflection;

/**
 * @author yechangfeng
 * @date 2019/1/3
 */
public class ReflectionInterfaceTest {
    public static void main(String[] args) throws Exception{
        //正常人是不会去获取一个接口的Class对象的，因为获取到之后没卵用，既不能反射实例化也没有静态方法给你调用
        //Class<TestInterface> testInterfaceClass = TestInterface.class;
        //TestInterface testInterface = testInterfaceClass.getConstructor().newInstance();

        Class<TestInterfaceImpl> implClass = TestInterfaceImpl.class;
        TestInterface testInterface = implClass.getConstructor(String.class).newInstance("lonely");
        testInterface.sayNoParam();

    }
}
