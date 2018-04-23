package com.strongant.designpattern.strategy;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class Context {
	private Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public void executeStrategy(int a, int b) {
		strategy.algorithm(a, b);
	}
}
