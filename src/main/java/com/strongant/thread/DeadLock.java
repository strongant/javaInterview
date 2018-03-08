package com.strongant.thread;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class DeadLock implements Runnable{
	private int flag = 1;
	// 静态对象是所有类共享的
	private static Object o1 = new Object(), o2 = new Object();


	@Override
	public void run() {
		System.out.println("flag  is : " + flag);
		if (flag == 1) {
			synchronized (o1) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (o2) {
					System.out.println("1");
				}
			}
		}

		if (flag == 0) {
			synchronized (o2) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				synchronized (o1) {
					System.out.println("0");
				}
			}
		}
	}

	public static void main(String[] args) {
		DeadLock t1 = new DeadLock();
		DeadLock t2 = new DeadLock();
		t1.flag = 1;
		t2.flag = 0;

		// t1 和 t2 都处于可运行状态，至于哪个先执行是不确定的
		new Thread(t1).start();
		new Thread(t2).start();
	}
}
