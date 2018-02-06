package com.strongant.parent;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class Test {
	public static void main(String[] args) {
		A ab = new B();
		ab = new B();

		/*Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				pong();
			}
		});
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print("ping");*/
	}

	static void pong() {
		System.out.print("pong");
	}
}


class A {
	static {
		System.out.print(1);
	}

	public A() {
		System.out.print(2);
	}
}

class B extends  A {
	static {
		System.out.print("a");
	}

	public B() {
		System.out.print("b");
	}
}

