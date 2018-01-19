package com.strongant.dyamicproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @see
 * @since 2017/8/20
 */
public class BookFacadeCglibProxy implements MethodInterceptor {


    private Object target;
    /**
     * 创建代理对象
     * @param target
     * @return
     */
    public Object getInstance(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        //创建代理对象
        return enhancer.create();
    }
    // 回调方法
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("---------->【开始执行任务】<--------");
        methodProxy.invokeSuper(obj,args);
        System.out.println("---------->【结束执行任务】<--------");
        return null;
    }


}
