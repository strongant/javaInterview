package com.strongant.designpatterns.observer;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class ObserverTest {
	public static void main(String[] args) {
		Student student = new Student(1, "A", "1991-01-01");
		Observer observer1 = new View1(student);
		Observer observer2 = new View2(student);

		student.register(observer1);
		student.register(observer2);

		View3 view3 = new View3(student);
		view3.changeStudent();

	}
}
