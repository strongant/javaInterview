package com.strongant.algorithm;

/**
 * 字符串数组反转
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class CharsReverse {
	public static void main(String[] args) {
		String origin = "abcde";
		String result = reverse(origin);
		System.out.println(result);
	}

	public static String reverse(String str) {
		if (null == str || str.length() == 0) {
			return str;
		}
		char[] array = str.toCharArray();
		int end = str.length() - 1;
		int halfLength = end / 2;
		for (int i = 0; i <= halfLength; i++) {
			char temp = array[i];
			array[i] = array[end-i];
			array[end-i] = temp;
		}
		return new String(array);
	}
}
