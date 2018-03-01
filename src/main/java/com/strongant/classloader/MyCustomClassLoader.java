package com.strongant.classloader;

import java.io.*;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class MyCustomClassLoader extends ClassLoader {

	private String name;        //类加载器名称

	private String path;        //加载类的路径

	private static final String fileType = ".class";


	public MyCustomClassLoader(String name) {
		super();  //让系统类加载器成为该类加载的父类加载器
		this.name = name;
	}

	public MyCustomClassLoader(ClassLoader parent, String name) {
		super(parent);
		this.name = name;
	}

	@Override
	public String toString() {
		return "MyCustomClassLoader{" +
				"name='" + name + "}";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public static void main(String[] args) throws IllegalAccessException, InstantiationException,
			ClassNotFoundException, Exception {
		MyCustomClassLoader loader1 = new MyCustomClassLoader("load1");
		loader1.setPath("src/com/strongant/classloader/test/classloader1");
		MyCustomClassLoader loader2 = new MyCustomClassLoader(loader1, "loader1");
		loader2.setPath("src/com/strongant/classloader/test/classloader2");
		MyCustomClassLoader loader3 = new MyCustomClassLoader(null, "loader3");
		loader3.setPath("src/com/strongant/classloader/test/classloader3");

		test(loader2);
		//test(loader3);
	}

	public static void test(ClassLoader classLoader) throws ClassNotFoundException, IllegalAccessException,
			InstantiationException {
		Class clazz = classLoader.loadClass("com.strongant.classloader.sample.Sample");
		Object object = clazz.newInstance();
	}

	private byte[] loadClassLoaderData(String name) {
		InputStream is = null;
		byte[] data = null;
		ByteArrayOutputStream byteArrayOutputStream = null;

		try {
			this.name = this.name.replace(".", "//");
			String filePath = path + name + fileType;
			System.out.println("filePath: " + filePath);
			if (!new File(filePath).exists()) {
				return null;
			}
			is = new FileInputStream(new File(filePath));
			byteArrayOutputStream = new ByteArrayOutputStream();

			int ch = 0;
			while ((ch = is.read()) != -1) {
				byteArrayOutputStream.write(ch);
			}
			data = byteArrayOutputStream.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != is) {
					is.close();
				}
				if (null != byteArrayOutputStream) {
					byteArrayOutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return data;
	}


	@Override
	public Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] data = this.loadClassLoaderData(name);
		return this.defineClass(name, data, 0, data.length);
	}
}
