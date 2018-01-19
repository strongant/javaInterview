package com.strongant.spring.require.reflect.test;

import com.strongant.spring.require.reflect.Car;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 学习Spring必学的Java基础知识(1)----反射
 * 使用反射的方法创建对象
 * Java 中将一个类载入JVM中，需要如下步骤：
 * <ol>
 *         <li>装载：查找和导入Class文件</li>
 *         <li>
 *             链接：执行校验、准备和解析步骤。
 *             <ol>
 *                 <li>校验： 检查载入Class文件的正确性</li>
 *                 <li>准备： 给类的静态变量分配存储空间</li>
 *                 <li>解析： 将符号引用转化为直接引用</li>
 *             </ol>
 *         </li>
 *         <li>初始化： 对类的静态变量、静态代码块执行初始化操作</li>
 * </ol>
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @see Car
 * @since 2017/8/20
 */
public class CarTest {

	public static void main(String[] args) throws Throwable {
		//plainObjectInvoke();

		Car car = initByCarDefaultConstruector();
		car.introduce();

		// 获取ClassLoader的名称和关系
		// AppClassLoader -> ExtClassLoader  --> 根加载器
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		System.out.println();
		System.out.println(classLoader);
		System.out.println(classLoader.getParent());
		System.out.println(classLoader.getParent().getParent());

	}

	public static Car initByCarDefaultConstruector() throws Throwable {
		// 通过类装载器获取Car类对象
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Class clazz = classLoader.loadClass("com.strongant.spring.require.reflect.Car");

		// 获取类的默认构造器对象，并且实例化
		Constructor constructor = clazz.getDeclaredConstructor((Class[]) null);
		Car car = (Car) constructor.newInstance();

		// 通过反射方法设置属性
		Method setBrand = clazz.getMethod("setBrand", String.class);
		setBrand.invoke(car, "红旗猫");

		Method setColor = clazz.getMethod("setColor", String.class);
		setColor.invoke(car, "红色");

		Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
		setMaxSpeed.invoke(car, 10);

		return car;
	}

	private static void plainObjectInvoke() {
		Car car = new Car("Car1", "红色", 100);
		car.introduce();
	}
}
