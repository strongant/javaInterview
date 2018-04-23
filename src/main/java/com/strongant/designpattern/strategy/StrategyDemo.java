package com.strongant.designpattern.strategy;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class StrategyDemo {
	public static void main(String[] args) {
		Context addContext = new Context(new AdditionStrategy());
		addContext.executeStrategy(1, 1);

		Context subContext = new Context(new SubstractStrategy());
		subContext.executeStrategy(1, 1);
	}
}
