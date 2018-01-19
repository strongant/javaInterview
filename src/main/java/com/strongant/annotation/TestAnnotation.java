package com.strongant.annotation;

/**
 * TODO
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @see
 * @since 2017/8/20
 */
public class TestAnnotation {

    @Test(id = 1,description = "method1")
    public void method1(){
        System.out.println("method1");
    }
    @Test(id = 2)
    public void method2() {}
    @Test(id = 3, description = "last method3")
    public void method3() {}
}
