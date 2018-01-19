package com.strongant.spring.require.noproxy.pojo;

/**
 * 用于封装监控方法调用性能的Pojo
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class MethodPerformance {
	private long begin;
	private long end;
	private String serviceMethod;

	public MethodPerformance(String serviceMethod){
		this.serviceMethod = serviceMethod;

		//记录目标类方法开始执行点的系统时间
		this.begin = System.currentTimeMillis();

	}

	public void printPerformance(){

		//获取目标类方法执行完成后的系统时间，并进而计算出目标类方法执行时间
		end = System.currentTimeMillis();
		long elapse = end - begin;

		//报告目标类方法的执行时间
		System.out.printf("%s 花费 %d 毫秒",serviceMethod, elapse);
	}


}
