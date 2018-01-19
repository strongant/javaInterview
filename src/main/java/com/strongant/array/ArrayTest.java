package com.strongant.array;

/**
 * Java数组的深入分析
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @see
 * @since 2017/8/20
 * <p>
 * Java中的数组变量是引用类型的变量
 */
public class ArrayTest {
	public static void main(String[] args) {
		//采用静态化方式初始化第一个数组
		String[] books = new String[]{
				"Spring",
				"Struts",
				"Hibernate",
				"SpringBoot"
		};
		//采用静态方式初始化第二个数组
		String[] menus = {
				"Apple",
				"Banana",
				"Pear"
		};

		// 使用动态初始化的方式初始化第三个数组
		String[] dynamicArray = new String[5];

		printlnSizeOfArray(books, menus, dynamicArray);

		// 以上三个数组的内存分配为，在栈区分配了三个变量，分别是： books、menus、dynamicArray，对应的堆区创建了分配了三个地址，
		// 分别别用于存放每个变量分配的值 , JavaScript中的数组是动态分配的，比如指定一个数组大小默认为0，然后动态指定数组的值，则数组
		// 会被自动扩大， Java中如果一个数组已经指定了默认大小，则不能动态进行分配指定值，如：menus[4] = "测试";
		// 则会抛出 java.lang.ArrayIndexOutOfBoundsException 异常


		// 改变数组的指向
		menus = books;
		dynamicArray = books;

		printlnSizeOfArray(books, menus, dynamicArray);

		// 数组一定要初始化吗？存在误区：我们常说在使用Java数组之前必须进行初始化，准确的描述应该是：使用Java数组对象之前应该初始化
		// 然而数组变量并不需要初始化

		String[] arr;

		arr = menus;

		System.out.println("arr size： " + arr.length);

		menus[0] = "测试改变menus";
		arr[0] = "测试改变";


		for (String s : menus) {
			System.out.println(s);
		}

		// Java中多维数组定义
		int[][] mutipleArray = new int[4][];

		// mutipleArray 数组的元素为引用类型 null
		for (int i = 0; i < mutipleArray.length; i++) {
			System.out.println(mutipleArray[i]);
		}
		mutipleArray[0] = new int[2];

		mutipleArray[0][1] = 6;

		// mutipleArray 数组的第一个元素是一个一维数组，遍历
		// 多维数组实质上演化过来还是一维数组
		for (int i = 0; i < mutipleArray[0].length; i++) {
			System.out.println("mutipleArray[0]:  " + mutipleArray[0][i]);
		}


	}

	/**
	 * 打印数组的大小
	 *
	 * @param books
	 * @param menus
	 * @param dynamicArray
	 */
	private static void printlnSizeOfArray(String[] books, String[] menus, String[] dynamicArray) {
		System.out.println("=============================");
		System.out.println("第一个数组的大小" + books.length);
		System.out.println("第二个数组的大小：" + menus.length);
		System.out.println("第三个数组的大小" + dynamicArray.length);
	}
}
