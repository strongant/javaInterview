package com.strongant.proxy;

import java.awt.print.Book;

/**
 * TODO
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @see
 * @since 2017/8/20
 */
public class BookFacadeImpl implements BookFacade {
    @Override
    public void addBook() {
        System.out.println("------》添加图书《-------");
    }
}
