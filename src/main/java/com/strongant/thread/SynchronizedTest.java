package com.strongant.thread;

import java.util.concurrent.locks.Lock;

/**
 * synchronized 锁定为 null 时 会抛出 NPE
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class SynchronizedTest {
	Object lock = new Object();

	public void test() {
		lock = null;
		synchronized (lock) {
			System.out.println("come in");
		}
	}

	public static void main(String[] args) {
		new SynchronizedTest().test();
	}
}
