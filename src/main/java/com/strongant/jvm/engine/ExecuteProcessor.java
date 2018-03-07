package com.strongant.jvm.engine;

/**
 * JVM 执行引擎执行过程：
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class ExecuteProcessor {
	public static void main(String[] args) {
		int a = 1;
		int b = 1;
		int c = (a + b) * 10;
		System.out.println(c);
	}
}
