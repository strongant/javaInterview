package com.strongant.servlet;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class CountingFactorizer{

	private static final AtomicLong count = new AtomicLong(0);

	public static Long getCount() {
		return count.get();
	}

	public static void service() {
		 count.incrementAndGet();
	}

	public static void main(String[] args) {
		CountingFactorizer.service();
		System.out.println(CountingFactorizer.getCount());
	}
}
