package com.strongant.jvm.stack;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class StackTest {
	public static void main(String[] args) {
		String[] params = {
				"a", "b"
		};
		new StackTest().stack(params);
	}

	public void stack(String[] args) {
		String str = "junshan";
		if (str.equals("junshan")) {
			int i = 3;
			while (i > 0) {
				long j = 1;
				i--;
			}
		} else {
			char b = 'a';
			System.out.println(b);
		}
	}
}
