package com.strongant.thread;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class DeadLockTest {
	public static void main(String[] args) {
		LoggingWigget loggingWigget = new LoggingWigget();
		loggingWigget.say();
	}
}


class Wigget {
	public synchronized void say() {
		System.out.println("Wigget hello");
	}
}

class LoggingWigget extends Wigget {

	public synchronized void say() {
		super.say();
		System.out.println("LoggingWigget ---- hello");
	}
}