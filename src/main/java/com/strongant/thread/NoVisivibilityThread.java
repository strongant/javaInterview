package com.strongant.thread;

/**
 * 线程可见性示例
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class NoVisivibilityThread {
	private static boolean ready;
	private static int number;

	private static class ReaderThreada extends Thread {
		@Override
		public void run() {
			while (!ready) {
				Thread.yield();
			}
			System.out.println(number);
		}
	}

	public static void main(String[] args) {
		new ReaderThreada().start();
		number = 42;
		ready = true;
	}
}
