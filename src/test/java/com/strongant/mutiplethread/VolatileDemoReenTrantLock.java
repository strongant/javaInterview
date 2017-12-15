package com.strongant.mutiplethread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * wait 与 notify 使用
 * 必须和 synchronized 一起使用
 * wait 释放锁(让当前对象处于等待状态)， notify 不释放锁(唤醒其他线程)
 * CountDownLatch通知锁 多用于远程连接等工作
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class VolatileDemoReenTrantLock {

	// volatile 只保证可见性，无法保证原子性
	private volatile int num = 0;
	// 可重入锁  java 1.5 后引入的高级特性
	private Lock lock = new ReentrantLock();

	public int getNum() {
		return this.num;
	}

	public void increase() {
		lock.lock();
		try {
			System.out.println("current thread name is :" + Thread.currentThread().getName());
			this.num++;
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final VolatileDemoReenTrantLock volatileDemoReenTrantLock = new VolatileDemoReenTrantLock();
		for (int i = 0; i < 500; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					volatileDemoReenTrantLock.increase();
				}
			}).start();
			// 休眠 模拟让出 CPU 使用资源
			Thread.sleep(10);
		}

		//如果还有子线程在执行，主线程让出cpu资源，直到子线程执行完毕，主线程继续执行
		while (Thread.activeCount() > 1) {
			Thread.yield();
		}
		System.out.println("-------num:" + volatileDemoReenTrantLock.getNum());
	}
}
