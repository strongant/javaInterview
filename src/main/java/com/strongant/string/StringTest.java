package com.strongant.string;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class StringTest {

	public static void main(String[] args){
		//changeString();
		StringBuffer sb = new StringBuffer();
		changeStringBuffer(sb);
		System.out.println(sb.toString());
	}

	private static void changeStringBuffer(StringBuffer sb) {
		sb.append(100);
	}

	private static void changeString() {
		String s = "111";
		change(s);
		System.out.println(s);
	}

	public static String change(String s){
		s = "222";
		return s;
	}
}
