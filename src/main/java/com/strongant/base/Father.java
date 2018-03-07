package com.strongant.base;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class Father {
	final void display() {
		System.out.println("Father");
	}

	public static void main(String[] args) {
		System.out.println(Math.plus(5));
	}
}

class Math {
	public static int plus(int num) {
		try {
			++num;
		} finally {
			return num ++;
		}
	}

}


