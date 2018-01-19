package com.strongant.spring.require.jdkdynamicproxy.test;

import com.strongant.spring.require.jdkdynamicproxy.proxy.PerformanceHandler;
import com.strongant.spring.require.jdkdynamicproxy.service.ForumService;
import com.strongant.spring.require.jdkdynamicproxy.service.impl.ForumServiceImpl;

import java.lang.reflect.Proxy;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class TestForumService {

	public static void main(String[] args) {
		// 1. 希望被代理的目标业务类
		ForumService target = new ForumServiceImpl();

		// 2. 目标业务类和横切代码编制到一起
		PerformanceHandler performanceHandler = new PerformanceHandler(target);

		// 3. 根据编织了目标业务类逻辑和性能监视横切逻辑的InvocationHandler实例创建代理实例
		ForumService proxy = (ForumService)Proxy.newProxyInstance(
				target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				performanceHandler
		);

		// 4. 调用代码示例
		proxy.removeForum(10);
		proxy.removeTopic(102);

	}
}
