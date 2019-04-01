package ycf.zero.local.springTheory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
* 这里简单模拟Spring扫描到类之后，如何生成代理对象并通过注解进行变量的赋值及方法的传参
*/
public class MainApp {
    public static void main(String[] args) throws Exception{
        //在Spring中是用Class.forName而不是用Xxx.class，因为Spring并不能提前知道开发者开发的类的名字
        Class<?> ycfClass = Class.forName("ycf.zero.local.springTheory.Ycf");
        Object object = ycfClass.newInstance();

        //遍历成员变量，设置成员变量的值
        Field[] fields = ycfClass.getDeclaredFields();
        for (Field field : fields) {
            if(field.isAnnotationPresent(NameAnnotation.class)){
                NameAnnotation nameAnnotation = field.getAnnotation(NameAnnotation.class);
                field.setAccessible(true);
                //这里和Method一样，如果是访问非静态成员变量，需要传一个对象
                field.set(object,nameAnnotation.name());
            }
            if(field.isAnnotationPresent(AgeAnnotation.class)){
                AgeAnnotation ageAnnotation = field.getAnnotation(AgeAnnotation.class);
                field.setAccessible(true);
                field.set(object,ageAnnotation.age());
            }
        }

        //遍历方法，把方法需要的参数传进去
        Method[] methods = ycfClass.getDeclaredMethods();
        for (Method method : methods) {
            if(method.isAnnotationPresent(GreetAnnotation.class)){
                GreetAnnotation greetAnnotation = method.getAnnotation(GreetAnnotation.class);
                //invoke方法的返回值是调用的方法的返回值，如果没有返回值则是null
                Object invoke = method.invoke(object, greetAnnotation.greetMsg());
                System.out.println(invoke);
            }
        }

        //赋值操作完成之后，利用jdkProxy或者cglib，生成一个代理对象
        CglibInterceptor cg = new CglibInterceptor(object);
        Object ycfProxy = cg.getProxy();

        //以上的代码就是Spring生成一个bean的过程，下面的代码是用户端的实验代码
        //Spring的写法是Ycf ycf = (Ycf)applicationContext.getBean("ycf");
        Ycf ycf = (Ycf)ycfProxy;
        System.out.println(ycf.getName());
        System.out.println(ycf.getAge());
    }
}
