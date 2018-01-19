package com.strongant.dyamicproxy;

import com.strongant.proxy.BookFacadeImpl;

/**
 * TODO
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @see
 * @since 2017/8/20
 */
public class TestCglib {

    public static void main(String[] args) {

        BookFacadeCglibProxy cglib=new BookFacadeCglibProxy();
        BookFacadeImpl bookFacade = (BookFacadeImpl) cglib.getInstance(new BookFacadeImpl());
        bookFacade.addBook();

    }
}
