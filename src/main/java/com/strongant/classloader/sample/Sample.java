package com.strongant.classloader.sample;

import com.strongant.classloader.sample.Dog;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class Sample {
	public int v1 = 1;
	public Sample() {
		System.out.println("Sample is loaded by " + this.getClass().getClassLoader());

		new Dog();
	}
}
