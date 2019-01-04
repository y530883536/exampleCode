package reflection;

/**
 * @author yechangfeng
 * @date 2019/1/3
 */
public class ReflectionObjectTest {
    public static void main(String[] args) throws Exception{
        //和容器一样，Class最好也指定类型
        Class<TestObject> objectClass = TestObject.class;

        //非static的方法，不管是直接调用还是反射调用，都需要一个实例
        TestObject test = objectClass.getConstructor().newInstance();
        test.sayNoParam();
        objectClass.getMethod("sayNoParam").invoke(test);

        //调用有参的方法
        objectClass.getMethod("sayWithParam",String.class).invoke(test,"fuckYou");

        //有参数的返回
        String value = (String)objectClass.getMethod("getValue").invoke(test);
        System.out.println(value);

        //调用静态方法，实例直接传null
        objectClass.getMethod("sayStatic").invoke(null);
    }
}
