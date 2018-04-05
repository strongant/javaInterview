package com.strongant.annotation;

import java.lang.reflect.Method;

/**
 * 测试使用自定义注解的类 {@link TestAnnotation}
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @see TestAnnotation
 * @since 2017/8/20
 */
public class AnnotationClientTest {


    public static void main(String[] args) {

        TestAnnotation testAnnotation = new TestAnnotation();

        testAnnotation.method1();
        testAnnotation.method2();
        testAnnotation.method3();


        Method[] methods = TestAnnotation.class.getDeclaredMethods();

        for (Method method : methods) {

            //判断方法中是否有目标类的注解
            boolean hasAnnotation = method.isAnnotationPresent(Test.class);

            if (hasAnnotation) {
                //根据注解类型返回方法的指定类型注解
                Test annotation = method.getAnnotation(Test.class);
                System.out.println("PrintOddEvenPlus(method=" + method.getName() + ",id=" + annotation.id()
                        + ",description=" + annotation.description() + ")");
            }
        }

        System.out.println(2147483647==Integer.MAX_VALUE);
    }
}
