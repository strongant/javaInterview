package com.strongant.print;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public  class PrintTest {
	public static void main(String[] args) {
		//new PrintTest().intPrint();
		// new PrintTest().getByteMinValueAndMaxValue();
		//new PrintTest().floatInit();

		// new PrintTest().divid(4, 0);


		// 输出  Vehicle drive
		//Car drive
		//Car drive

		// parentChildPrint();


		// breakTest();

		// forTest();

		//andOrTest();


		// new PrintTest().method2();


		// Web应用发布描述文件指的就是 web.xml  位于项目的 WEB-INF/web.xml  题目描述文件审题不清楚，导致错误，


		// 用 jsp:include 控制动态内容 <%@ include 和 <jsp:include page="bookshelf.jsp" flush="true" />
		// 使用 forward 和 jso:include ， 这个忘记了 没答上来
		//<%@include file=""%>
		// 可以包含任何的文件，可以把任何文件的内容直接包含进来，文件包含的时候不需要后缀。所以此种包含属于静态包含，只关心文件本身的内容。


		// HttpServletRequest#getParameterValues 方法用于获取同一个表单元素名称的值数组，通过下表可以得到内容

	}



	public void test(HttpServletRequest request, HttpSession session) {
		String[] args = request.getParameterValues("a");
		int a = (int)request.getAttribute("a");
		session.setAttribute("abcdefghijklmn","a");
	}

	// 答错了 考察 单 & 和 双 && 、 |（按位或　　它们都是位运算符 ) 和 || （短路或者，只要有一个为 0 即可）  || 和  && 具有短路功能， | 和 & 总要执行右边的操作
	// 第一个输出 3 第二个输出 1
	private static void andOrTest() {
		int i = 0;
		int j = 0;
		boolean t = true;
		boolean r;

		r = (t & 0 < (i += 1));
		r = (t && 0 < (i += 2));
		r = (t | 0 > (j+=1));
		r = (t || 0 > (j+=2));

		System.out.println(i + " " + j);
	}

	// 考察 for 循环的执行条件
	private static void forTest() {
		int total = 0;

		for (int i = 0,j = 10; i > 30 ; ++i, --j) {
			System.out.println("i= " + i + " j = " + j);
			total += (i+j);
		}

		System.out.println("total: " + total);
	}

	// 考擦 switch case 不加 break 怎样执行
	private static void breakTest() {
		int x = 2;
		switch (x) {
			case 1:
				System.out.println(1);
			case 2:
			case 3:
				System.out.println(3);
			case 4:
				System.out.println(4);
		}
	}

	// 考察父类接收子类 做错了
	private static void parentChildPrint() {
		Vehicle vehicle;
		Car car;

		vehicle = new Vehicle();
		car = new Car();

		vehicle.drive();
		car.drive();
		vehicle = car;
		vehicle.drive();
	}

	// 考察 float 赋值
	private  void floatInit() {
		int a = 32;
		float f = (float)45.0; // 默认为 double 类型， 需要强制转换
		double d = 45.d;
	}

	// 选择题 1 考察变量未初始化进行计算 应该是不可编译 做错了
	/*private  void intPrint() {
		int age;
		age = age + 1;
		System.out.println("The age is : " + age);
	}*/

	// 选择题 2 考察 Byte 数据类型的范围 -127 到 128  做错了 题目本身有问题
	private void getByteMinValueAndMaxValue() {
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Byte.MAX_VALUE);
	}

	// 选择题 4 考察抽闲方法, 题目不严谨 应该是在抽象类中定义抽象方法,选择 1 做错了
	/*1. public abstract void add1();*/
	/*public abstract void add2() {};
	public abstract  add3() {};
	public virtual  add4() {};*/

	// 考察 try catch finally 执行机制
	public void divid(int a, int b) {
		try {
			int c = a / b;
		} catch (Exception e) {
			System.out.println("Exception");
		} finally {
			System.out.println("Finally");
		}
	}


	private void method1() throws Exception{
		throw new RuntimeException();
	}

	// 考察 同事捕获父类异常和子类异常时 只会捕获子类异常 RuntimeException 继承 Exception
	// 运行时显示 Caught RuntimeException
	// 答错了
	public void method2() {
		try {
			method1();
		} catch (RuntimeException e) {
			System.out.println("Caught RuntimeException");
		}catch (Exception e) {
			System.out.println("Caught Exception");
		}
	}


}

// 5 考察子类父类执行
class Vehicle {
	public void drive() {
		System.out.println("Vehicle drive");
	}
}

class Car extends Vehicle {
	public void drive() {
		System.out.println("Car drive");
	}
}


// 考察 final 类不能被继承 private 关键字的范围  做错了 所以应该是： a 是私有类型， 除了 First 其它类不能访问。Second 不能扩展  First
final class First {
	private int a = 1;
	int b = 2;
}

//class Second extends First {
//	public void method() {
//		System.out.println(a + b);
//	}
//}

