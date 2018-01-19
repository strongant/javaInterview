package com.strongant.exception;

/**
 * TODO
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @see
 * @since 2017/8/20
 */
public class Throws {

    public static void main(String[] args) {


        String str = null;

        //e.g. com.jk.util.SpringUtils#getBean Assert.notNull(type);
        Throws.notNull(str,"参数不能为空");

        System.out.println("抛出后是否继续执行");
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
