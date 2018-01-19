package com.strongant.objectiwthmemory.usefinal;

/**
 * final修饰符练习
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @see
 * @since 2017/8/20
 */
public class FinalTest {

	private final String var1 = "Bootstrap";

	private final String var2;

	private final String var3;

	{
		var2 = "SpringBoot";
	}

	public FinalTest() {
		this.var3 = "SpringSecurity";
	}

	public static void main(String[] args) {
		FinalTest finalTest = new FinalTest();

		System.out.println(finalTest.var1);
		System.out.println(finalTest.var2);
		System.out.println(finalTest.var3);
	}
}
