package com.strongant.thread;

/**
 * 有三个线程执行 线程 2 在线程 1 之后执行 线程 3 在线程 2 之后执行
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class JoinTest {
	public static void main(String[] args) throws Exception{
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("t1: " + i);
				}
			}
		});

		t1.start();
		t1.join();
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("t2: " + i);
				}
			}
		});

		t2.start();

		t2.join();
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("t3: " + i);
				}
			}
		});

		t3.start();
	}
}
