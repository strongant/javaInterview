package com.strongant.jvm.classloader;

import com.strongant.jvm.classloader.custom.Dog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 继承 ClassLoader 自定义 ClassLoader
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class NetClassLoader extends ClassLoader {
	private String classPath;
	private String packageName = "com.strongant.jvm.classloader.custom";

	public NetClassLoader(String classPath) {
		this.classPath = classPath;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> clazz = findLoadedClass(name);
		if (clazz != null) {
			return clazz;
		}

		if (packageName.startsWith(name)) {
			byte[] classData = getData(name);
			if (null == classData) {
				throw new ClassNotFoundException();
			} else {
				return defineClass(name, classData, 0, classData.length - 1);
			}

		} else {
			return super.loadClass(classPath);
		}
	}

	private byte[] getData(String className) {
		String path = classPath + File.separator + className.replace('.', File.separatorChar) + ".class";

		try {
			URL url = new URL(path);
			InputStream is = url.openStream();
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			byte[] buffer = new byte[2048];
			int num = 0;
			while ((num = is.read(buffer)) != -1) {
				stream.write(buffer, 0, num);
			}
			return stream.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
