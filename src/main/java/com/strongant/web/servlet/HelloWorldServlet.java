package com.strongant.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class HelloWorldServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ClassLoader classLoader = this.getClass().getClassLoader();
		while (classLoader != null) {
			System.out.println(classLoader.getClass().getCanonicalName());
			classLoader = classLoader.getParent();
		}
	}
}
