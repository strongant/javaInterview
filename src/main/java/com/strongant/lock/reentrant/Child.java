package com.strongant.lock.reentrant;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class Child extends Fatcher {
	public synchronized void test() {
		// 这里调用父类的同发方法，首先会获取父类的内置锁，然后获取子类的内置锁，如果不能重入，则会进入死锁。
		super.test();
	}

	public static void main(String[] args) {
		new Child().test();
	}
}
