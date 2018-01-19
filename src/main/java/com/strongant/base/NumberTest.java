package com.strongant.base;

/**
 * TODO
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @see
 * @since 2017/8/20
 */
public class NumberTest {

    public static void main(String[] args) {


        //Integer cache -128 - 127
        //如果需要比较Integer中的值则只需要使用compareTo方法进行比较即可
        //compareTo源码定义如下：
        //return compare(this.value, anotherInteger.value);
        //return (x < y) ? -1 : ((x == y) ? 0 : 1);
        Integer a = 127;
        Integer b = 124;

        System.out.println(a.compareTo(b));
    }
}
