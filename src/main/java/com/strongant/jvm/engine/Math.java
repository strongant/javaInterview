package com.strongant.jvm.engine;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class Math {

	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int c = math(a, b) / 10;
	}

	private static int math(int a, int b) {
		return (a + b) * 10;
	}
}
