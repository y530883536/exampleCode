package designPattern.proxy.dynamicProxy.cglibProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

public class CglibInterceptor implements MethodInterceptor {

    private Object target;

    public CglibInterceptor(Object target){
        this.target = target;
    }

    public Object getProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result1 = methodProxy.invoke(target, objects);
        //Object result2 = method.invoke(target, objects);
        after();
        return result1;
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
