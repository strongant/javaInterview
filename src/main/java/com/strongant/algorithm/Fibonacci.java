package com.strongant.algorithm;

/** 斐波那契数列实现
 *  数组规律 1 1 2 3 5 8 13 21 35
 *  递推公式 F(n) = F(n-1) + F(n-2)
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class Fibonacci {
	public static void main(String[] args) {
		//int result = fibonacci(6);
		long result  = fib2(6);
		System.out.println(result);
	}

	// 递归实现 时间复杂度  O(2^N)
	public static int fibonacci(int num) {
		if ((num == 1) || (num == 0)) {
			return 1;
		}
		return fibonacci(num - 1) + fibonacci(num - 2);
	}

	/**
	 * 斐波那契非递归实现，时间复杂度 O(n)
	 * @param num
	 * @return
	 */
	public static long fib2(int num) {
		assert(num >= 0);
		//非递归
		long[] array = new  long[num+1];
		array[0] = 1;
		array[1] = 1;
		for (int i=2; i<=num; i++)
		{
			array[i] = array[i-1] + array[i-2];
		}
		return array[num];
	}


}
