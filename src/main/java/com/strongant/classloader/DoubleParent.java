package com.strongant.classloader;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class DoubleParent {
	public static void main(String[] args) {
		ClassLoader classLoader = DoubleParent.class.getClassLoader();
		while (classLoader != null) {
			System.out.println(classLoader.getClass().getCanonicalName());
			classLoader = classLoader.getParent();
		}
	}
}
