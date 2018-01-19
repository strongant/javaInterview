package com.strongant.mutiplethread;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class Test {
	public static void main(String[] args) {
		factorial(5000);
	}

	static void factorial(int n)
	{
		int[] a = new int[100000];//结果存放数组
		int carry, tmp, digit;//进位，具体位乘积，位数
		int i, j;

		a[0] = 1;
		digit = 1;
		carry = 0;
		for (i = 2; i <= n; i++)
		{
			for (j = 0; j < digit; j++)
			{
				tmp = a[j] * i + carry;
				carry = tmp / 10;
				a[j] = tmp % 10;
			}
			while (carry > 0)
			{
				digit++;
				a[digit-1] = carry % 10;
				carry = carry / 10;
			}
		}
		System.out.println("结果为： " + n);
		for (int k = digit - 1; k >= 0; k--)
		{
			System.out.print(a[k]);
		}

	}
}
