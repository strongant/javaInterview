package com.strongant.thread;

/**
 * 开启两个线程，一个线程打印1到100的奇数。如1，3，7...99. 另外一个线程打印1到100的偶数。
 * 如2，4，6...100.  1到100的数字最终打印出来格式是1,2,3,4,5...100. 要求用synchronized和wait实现.
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class PrintOddEven {

	private static final int MAX_VALUE = 100;

	public static void main(String[] args) {

		final Num num = new Num();

		// 线程 A 负责打印奇数
		Thread threadA = new Thread(new Runnable() {
			@Override
			public void run() {
				printOdd(num);
			}
		});
		threadA.start();


		// 线程 B 负责打印偶数
		Thread threadB = new Thread(new Runnable() {
			@Override
			public void run() {
				printEven(num);
			}
		});
		threadB.start();
	}

	/**
	 * 打印奇数
	 */
	private static void printOdd(Num lock) {
		while (lock.num < MAX_VALUE) {
			//两个线程都用t对象作为锁，保证每个交替期间只有一个线程在打印
			synchronized (lock) {
				// 如果 lock.isEven, 说明此时尚未轮到线程 A 打印, 线程 A 将调用t的wait()方法, 直到下次被唤醒
				if (lock.isEven) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " : " + lock.num);
				// 线程 A 打印完成后, 将 isEven 赋值为 true, 表示接下来将轮到线程 B 打印
				lock.isEven = true;
				lock.num ++;
				// notifyAll() 方法唤醒在 t 上 wait 的线程 B, 同时线程 A 将退出同步代码块, 释放t锁
				lock.notifyAll();
			}
		}
	}

	/**
	 * 打印偶数
	 */
	private static void printEven(Num lock) {
		while (lock.num <= MAX_VALUE) {
			//两个线程都用t对象作为锁，保证每个交替期间只有一个线程在打印
			synchronized (lock) {
				// 如果  !lock.isEven , 说明此时尚未轮到线程 B 打印, 线程 B 将调用t的wait()方法, 直到下次被唤醒
				if (!lock.isEven) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " : " + lock.num);
				// 线程 B 打印完成后, 将 isEven 赋值为 true, 表示接下来将轮到线程 A 打印
				lock.isEven = false;
				lock.num ++;
				// notifyAll()方法唤醒在 t 上 wait 的线程 B , 同时线程 B 将退出同步代码块, 释放t锁
				lock.notifyAll();
			}
		}
	}
}

class Num {
	boolean isEven = false;
	int num = 1;
}
