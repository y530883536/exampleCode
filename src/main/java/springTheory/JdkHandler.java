package springTheory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkHandler implements InvocationHandler {

    private Object target;

    public JdkHandler(Object target){
        this.target = target;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    private void before(){
        System.out.println("使用JDK代理(接口)创建代理");
    }

    private void after(){
        System.out.println("JDK代理创建完毕");
    }
}
