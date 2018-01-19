package com.strongant.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @see
 * @since 2017/8/20
 */
//该注解用于方法声明
@Target(ElementType.METHOD)
//VM将在运行期也保留注释，因此可以通过反射机制读取注解的信息
@Retention(RetentionPolicy.RUNTIME)
//将此注解包含在javadoc中
@Documented
//允许子类继承父类注解
@Inherited
public @interface Test {
    int id();
    String description() default "no description";
}
