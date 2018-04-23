package com.strongant.designpattern.strategy;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class AdditionStrategy implements Strategy {
	@Override
	public void algorithm(int a, int b) {
		System.out.println("加法运算 (a + b) = " + (a + b));
	}
}
