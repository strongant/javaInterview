package com.strongant.thread;

/** Java Thread run 方法考察
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class ThreadExecute {
	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				pong();
			}
		});

		t.run();
		System.out.println("ping");
	}

	public static void pong() {
		System.out.println("pong");
	}
}
