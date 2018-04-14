package com.strongant.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
@WebServlet("/test")
public class HelloWorldServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*ClassLoader classLoader = this.getClass().getClassLoader();
		while (classLoader != null) {
			System.out.println(classLoader.getClass().getCanonicalName());
			classLoader = classLoader.getParent();
		}*/

		// 测试 request  获取值
		String second1 = req.getParameter("foo");
		System.out.println("second1: " + second1);
		// 错误取法
		//String second1 = req.getParameter("foo",1);
		//String second2 = req.getParameter("foo",2);
		// 默认返回 String
		//String second3 = req.getParameter("foo")[1];


		String second4 = req.getParameterValues("foo")[1];
		System.out.println("second4: " + second4);

	}
}
