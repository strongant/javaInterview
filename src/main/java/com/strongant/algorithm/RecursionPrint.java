package com.strongant.algorithm;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class RecursionPrint {
	public static void main(String[] args) {
		int maxValue = 10;
		recursionPrint(maxValue);
	}

	private static void recursionPrint(int maxValue) {
		if (maxValue < 0 ) return;
		System.out.println(maxValue);
		recursionPrint(-- maxValue);
	}
}
