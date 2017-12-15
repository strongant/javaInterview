package com.strongant.mutiplethread;

/**
 *  使用 notify 和 wait 模拟生产者、消费者
 *  不加锁的情况下一般最终结果不是 500
 *  ++ 操作不是线程安全的
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class VolatileDemo {

	/**
	 * volatile只有可见性，无法保证原子性
	 */
	private volatile int num = 0;

	public int getNum() {
		return this.num;
	}

	public void increase() {
		try {
			System.out.println("ThreadName: " + Thread.currentThread().getName());
			//休眠更容易重现结果不为500
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.num++;
	}

	public static void main(String[] args) {
		final VolatileDemo volatileDemo = new VolatileDemo();
		for (int i = 0; i < 500; i++) {
			new Thread(new Runnable() {
				public void run() {
					volatileDemo.increase();
				}
			}).start();
		}
		//如果还有子线程在执行，主线程让出cpu资源，直到子线程执行完毕，主线程继续执行
		System.out.println(Thread.activeCount());
		while (Thread.activeCount() > 1) {
			Thread.yield();
		}
		System.out.println("-------num:" + volatileDemo.getNum());
	}
}
