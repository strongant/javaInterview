package com.strongant.base.string;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class Main {
	public static void main(String[] args) {
		String s1 = "a";
		String s2 = "b";
		String s3 = s1 + s2;

		StringBuffer sb = new StringBuffer();
		sb.append("a");
		sb.append("b");
		String sbResult = sb.toString();

	}
}
