package com.strongant.algorithm;

/**
 * 字符串数组反转
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class CharsReverse {
	public static void main(String[] args) {
		char[] chars = {'a', 'b', 'c'};
		reverse(chars);
		for (char aChar : chars) {
			System.out.println(aChar);
		}
	}

	public static void reverse(char[] chars) {
		if (chars != null && chars.length > 0) {
			int len = chars.length - 1, middle = len / 2;
			for (int i = 0; i < middle; i++) {
				final char temp = chars[len - i];
				chars[len - i] = chars[i];
				chars[i] = temp;
			}
		}
	}
}
