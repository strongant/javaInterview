package com.strongant.objectiwthmemory;

/**
 * 对象与内存控制
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @see
 * @since 2017/8/20
 */
public class ObjectOfMemoryTest {

	// 类成员是ObjectOfMemoryTest 实例
	final static ObjectOfMemoryTest INSTANCE = new ObjectOfMemoryTest(2.8);

	//定义一个类变量  添加final后则可以在编译期间为变量赋值
	static int initPrice = 20;

	// 定义ObjectOfMemoryTest 类的实例变量
	double currentPrice;

	public ObjectOfMemoryTest(double currentPrice) {
		// 根据静态变量计算实例变量
		this.currentPrice = initPrice - currentPrice;
	}

	public static void main(String[] args) {

		// 非法前向引用
		/*int num1 = num2 + 2;
		int num2 = num2;*/

		// 如果initPrice是类变量，则正常可以使用
		/*int num1 = initPrice + 2;

		System.out.println("num1 = " + num1);*/

		// 通过ObjectOfMemoryTest 的INSTANCE 访问实例变量currentPrice
		System.out.println(ObjectOfMemoryTest.INSTANCE.currentPrice);

		// 显示创建ObjectOfMemoryTest实例
		// 输出为-2.8 由JVM内存分配次序可知 首先INSTANCE最先分配为null， initPrice = 0 currentPrice = 0
		// 接着开始执行ObjectOfMemoryTest(double currentPrice)方法，此时currentPrice = 0 ，所以调用后变为
		// 0 - 2.8  = -2.8 , 因此结果返回为-2.8
		ObjectOfMemoryTest objectOfMemoryTest = new ObjectOfMemoryTest(2.8);
		System.out.println(objectOfMemoryTest.currentPrice);


		System.out.println(new Animal("animal"));
	}
}

class Capture {

	{
		System.out.println("Capture 的非静态初始化块");
	}

	public Capture() {
	}

	public Capture(String name) {
		// 使用this 重载调用另一个午参的构造函数
		this();

		System.out.println("Capture 带有name参数的构造器，name参数： " + name);
	}


}

class Animal extends  Capture {
	{
		System.out.println("Animal 的非静态初始化块");
	}

	public Animal(String name) {
		super(name);
		System.out.println("Animal 一个带参数的构造器， name参数：" + name);
	}

	public Animal(String name, Integer age) {
		this(name);
		System.out.println("Animal 一个带两个参数的构造器， age参数：" + age);
	}


}