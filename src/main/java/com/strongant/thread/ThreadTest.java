package com.strongant.thread;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class ThreadTest {
	public static void main(String[] args) {

		// 覆盖 父类的 run 方法
		Thread thread = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						System.out.println("当期线程 :");
						System.out.println(Thread.currentThread().getName());
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread.start();
	}
}
