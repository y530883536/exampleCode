package local.designPattern.proxy.dynamicProxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkHandler implements InvocationHandler {

    private Object target;

    public JdkHandler(Object targetObject){
        this.target = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //这里会对所有方法都进行增强，所以在平时写的时候这里一般会做方法名的判断然后进行不同的逻辑处理
        before();
        Object result = method.invoke(target,args);
        after();
        return result;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }

    private void before(){
        System.out.println("proxy：中介公司开始代理租房子业务");
        System.out.println("proxy：把房子打扫干净");
        System.out.println("proxy：挂在闲鱼上");
    }

    private void after(){
        System.out.println("proxy：租出去了");
        System.out.println("proxy：跟房东和租客收佣金");
    }
}
