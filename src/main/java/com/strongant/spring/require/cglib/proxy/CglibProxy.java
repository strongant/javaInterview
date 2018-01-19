package com.strongant.spring.require.cglib.proxy;

import com.strongant.spring.require.noproxy.pojo.PerformanceMonitor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class CglibProxy implements MethodInterceptor {

	private Enhancer enhancer = new Enhancer();

	public Object getProxy(Class clazz) {
		enhancer.setSuperclass(clazz);  // 设置需要创建子类的类
		enhancer.setCallback(this);
		return enhancer.create();  // 通过字节码技术动态创建子类实例
	}

	// 拦截父类所有方法的调用
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		PerformanceMonitor.begin(o.getClass().getName() + "." + method.getName());
		Object result = methodProxy.invokeSuper(o ,objects);
		PerformanceMonitor.end();  // 通过代理类调用父类中的方法
		return result;
	}
}
