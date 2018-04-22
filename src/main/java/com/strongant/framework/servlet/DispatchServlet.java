package com.strongant.framework.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class DispatchServlet extends HttpServlet {


	private Properties properties = new Properties();

	private Map<String, Object> beanMap = new ConcurrentHashMap<>();

	private List<String> beanName = new ArrayList<>();



	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

	@Override
	public void init() throws ServletException {


		// 开始初始化的方法


		// 定位
		doLoadConfig();

		// 加载
		doScanner();


		// 注册
		doRegistry();


		// 自动依赖注入
		doAutoWired();


		/**
		 * SpringMVC 会多设计一个 Mapping  HandleMapping
		 * 将 @RequestMapping 配置的 url 和 一个 Method 关联起来
		 * 以便于从浏览器进行访问时，得到具体的 method 进行反射调用
		 */
		initHandleMapping();

	}

	private void initHandleMapping() {
	}

	private void doRegistry() {
	}

	private void doAutoWired() {
	}

	private void doInstance() {
	}

	private void doScanner() {
	}

	/**
	 * 以 do 开头的就是干活的方法
	 * 在 Spring 中通过一个 Reader 进行查找和定位的
	 */
	private void doLoadConfig() {

	}


}
