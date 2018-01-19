package com.strongant.spring.require.noproxy.pojo;

import com.strongant.spring.require.noproxy.pojo.MethodPerformance;

/**
 * 对性能测试POJO进行管理
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class PerformanceMonitor {
	// 通过一个ThreadLocal保存线程调用的性能检测信息
	private static ThreadLocal<MethodPerformance> performanceRecord =
			new ThreadLocal<>();

	// 启动对某一目标方法的性能监视
	public static void begin(String method) {
		System.out.println("begin method ...");
		MethodPerformance methodPerformace = new MethodPerformance(method);
		performanceRecord.set(methodPerformace);
	}

	public static void end() {
		System.out.println("end monitor ...");
		MethodPerformance methodPerformace = performanceRecord.get();

		// 打印性能检测信息
		methodPerformace.printPerformance();
	}
}
