package com.strongant.mutiplethread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 使用 CountDownLaunch 替代 wait 和 notify
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class CountDownLaunch {
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

		final CountDownLatch countDownLatch = new CountDownLatch(1);

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("t2启动");
				if (c.size() != 5) {
					System.out.println("t2--->当前集合大小:" + c.size());
					System.out.println("t2--->当前线程名字：" + Thread.currentThread().getName());
					try {
						// 阻塞 让其他线程进行执行
						countDownLatch.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("t2--->当前集合大小:" + c.size());
				System.out.println("t2 结束");
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

				for (int i = 0; i < 10; i++) {
					c.add(new Object());
					System.out.println("t1--->当前线程名字: " + Thread.currentThread().getName() + "add " + i);

					if (c.size() == 5) {
						System.out.println("t1----> 让其他线程执行");
						countDownLatch.countDown();
					}

					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}, "t1").start();
	}
}
