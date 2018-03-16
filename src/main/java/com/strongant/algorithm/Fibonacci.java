package com.strongant.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 斐波那契数列实现
 * 数组规律 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
 * 0 不是第一项而是第 0 项
 * 递推公式 F(n) = F(n-1) + F(n-2)
 * a_{1}=1
 * {\displaystyle a_{2}=1} a_{2}=1
 * {\displaystyle a_{n}=a_{n-1}+a_{n-2}} a_{n}=a_{{n-1}}+a_{{n-2}}
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class Fibonacci {
	public static void main(String[] args) {
		//int result = fibonacci(100);
		//long result = fib2(100);
		List<Long> results = new ArrayList<>();
		int max = 100;
		for (int i = -3; i < max; i++) {
			long result = fib3(i);
			results.add(result);
		}
		System.out.println(results);
	}

	// 递归实现 时间复杂度  O(2^N)
	public static int fibonacci(int num) {
		if (num <= 1) {
			return num;
		}
		return fibonacci(num - 1) + fibonacci(num - 2);
	}

	/**
	 * 斐波那契非递归实现，时间复杂度 O(n)
	 *
	 * @param num
	 * @return
	 */
	public static long fib2(int num) {
		if (num < 0) {
			return -1;
		}
		if (num <= 1) {
			return num;
		}
		if (num == 2) {
			return 1;
		}
		long[] array = new long[num + 1];
		array[0] = 0;
		array[1] = 1;
		array[2] = 1;
		for (int i = 3; i <= num; i++) {
			array[i] = array[i - 1] + array[i - 2];
		}
		return array[num];
	}

	/**
	 * 斐波那契非递归实现另外一种计算思路
	 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
	 *
	 * @param num
	 * @return
	 */
	public static long fib3(long num) {
		int n1 = 0, n2 = 1, n3, i;

		if (num < 0) {
			return -1;
		}
		if (num <= 1) {
			return num;
		}

		for (i = 2; i < num; ++i) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
		}
		return n1 + n2;
	}

}
