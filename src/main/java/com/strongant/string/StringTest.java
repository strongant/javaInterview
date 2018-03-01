package com.strongant.string;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class StringTest {

	public static void main(String[] args){
		//changeString();
		/*StringBuffer sb = new StringBuffer();
		changeStringBuffer(sb);
		System.out.println(sb.toString());*/

		String str1 = "hello";
		String str2 = "he" + new String("llo");
		String str3 = "hello";

		System.out.println(Integer.toHexString(str1.hashCode()));
		System.out.println(Integer.toHexString(str2.hashCode()));
		System.err.println(str1 == str2);
		System.err.println(str1 == str3);
		System.err.println(str1.equals(str2));

	}

	private static boolean verify(String s, String s1) {
		return s == s1;
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
