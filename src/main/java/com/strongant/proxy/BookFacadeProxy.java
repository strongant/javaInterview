package com.strongant.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * TODO
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @see
 * @since 2017/8/20
 */
public class BookFacadeProxy implements InvocationHandler {

    private Object target;

    public Object bind(Object target){
        this.target = target;
        System.out.println("-----------bind------");
        //this即绑定当前
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("----------->【任务执行前】<-----------");
        result = method.invoke(target,args);
        System.out.println("----------->【任务结束】<-----------");
        return result;
    }
}
