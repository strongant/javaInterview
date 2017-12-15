package com.strongant.mutiplethread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 使用 notify 和 wait 结合 synchronized 操作
 * wait 释放锁 notify 不释放锁
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class NotifyWaitSynchronized {

	//添加volatile，使t2能够得到通知
	volatile List lists = new ArrayList();

	public void add(Object o) {
		lists.add(o);
	}

	public int size() {
		return lists.size();
	}

	public static void main(String[] args) {
		final NotifyWaitSynchronized c = new NotifyWaitSynchronized();

		final Object lock = new Object();

		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					System.out.println("t2启动");
					if (c.size() != 5) {
						try {
							System.out.println("当前集合大小:" + c.size());
							System.out.println("t2--->当前线程名字：" + Thread.currentThread().getName());
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("当前集合大小:" + c.size());
					System.out.println("t2 结束");
					//通知t1继续执行
					lock.notify();
				}
			}
		}, "t2").start();

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("t1启动");
				synchronized (lock) {
					for (int i = 0; i < 10; i++) {
						c.add(new Object());
						System.out.println("t1--->当前线程名字: " + Thread.currentThread().getName() + "add " + i);

						if (c.size() == 5) {
							lock.notify();
							//释放锁，让t2得以执行
							try {
								lock.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}, "t1").start();
	}
}
