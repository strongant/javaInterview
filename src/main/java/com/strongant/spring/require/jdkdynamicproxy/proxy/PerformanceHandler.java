package com.strongant.spring.require.jdkdynamicproxy.proxy;

import com.strongant.spring.require.noproxy.pojo.PerformanceMonitor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 实现InvocationHandler
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class PerformanceHandler implements InvocationHandler{ //①实现InvocationHandler

	private Object target;

	public PerformanceHandler(Object target) { //②target为目标的业务类
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		PerformanceMonitor.begin(target.getClass().getName()+"."+ method. getName()); //③-1
		Object obj = method.invoke(target, args);// ③-2通过反射方法调用业务类的目标方法
		PerformanceMonitor.end();
		return obj;
	}
}
