package com.strongant.classloader.sample;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class Dog {
	public Dog() {
		System.out.println("Dog is loaded by " + this.getClass().getClassLoader());
	}
}
