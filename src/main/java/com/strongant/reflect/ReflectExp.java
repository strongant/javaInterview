package com.strongant.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectExp {
	public static void main(String[] args) {
		Class p = Person.class;
		Person p1 = new Person();
		System.out.println(p);
		Field[] fields = p.getDeclaredFields();
		for (Field f : fields) {
			System.out.print(Modifier.toString(f.getModifiers()) + " ");
			System.out.print(f.getType().getSimpleName() + " ");
			System.out.println(f.getName() + " ");
		}
		Method[] ms = p.getDeclaredMethods();
		for (Method m : ms) {
			System.out.print(m.getName() + " ");
		}
		System.out.println("Test Annotation: ");
		try {
			for (Field f : fields) {
				if (f.isAnnotationPresent(DefaultName.class)) {
					DefaultName name = f.getAnnotation(DefaultName.class);
					f.setAccessible(true);
					f.set(p1, name.value());
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		System.out.println(p1.getName());
	}
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface DefaultName {
	String value() default "Jack";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface DefaultAge {
	int value() default 20;
}

class Person {
	@DefaultName
	private String name;
	@DefaultAge
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void sayHi() {
		System.out.print("Say Hi from " + this.name);
	}
}
