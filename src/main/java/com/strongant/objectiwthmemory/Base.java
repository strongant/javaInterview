package com.strongant.objectiwthmemory;

/**
 * TODO
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @see
 * @since 2017/8/20
 */
public class Base {

	// 定义一个名为i的实例变量
	private int i  = 2;

	public Base() {
		System.out.println(this.i);
		this.display();
		System.out.println(this.getClass());
	}

	private void display() {
		System.out.println(i);
	}
}
