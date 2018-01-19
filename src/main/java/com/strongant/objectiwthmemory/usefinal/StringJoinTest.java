package com.strongant.objectiwthmemory.usefinal;

/**
 * 字符串链接测试
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @see
 * @since 2017/8/20
 */
public class StringJoinTest {
	public static void main(String[] args) {
		String s1 = "Java";
		String s2 = "Ja" + "va";
		System.out.println(s1 == s2);

		//noFinal(s1);

		final String str1  = "Ja";
		final String str2 = "va";

		String str3 = str1 + str2;

		// 被final变量修饰的变量  会进行宏替换
		System.out.println(s1 == str3);


	}

	private static void noFinal(String s1) {
		String str1  = "Ja";
		String str2 = "va";

		String str3 = str1 + str2;

		// 不会执行宏替换，结果为false
		System.out.println(s1 == str3);
	}
}