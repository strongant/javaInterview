package com.strongant.spring.require.framework.context;

import com.strongant.spring.require.framework.beans.BeanDefinition;
import com.strongant.spring.require.framework.context.support.BeanDefinitionReader;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class ApplicationContext {


	/**
	 * 用来保存配置信息
	 * 使用 cache 保证单例
	 */
	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();


	private BeanDefinitionReader reader;

	public void refresh() {


		// 定位

		// 加载

		// 注册

		// 依赖注入 (lazy-init = false) 执行依赖注入
		// 自动调用  getBean 方法,如果是接口，则通过接口的实现类来实例化

		this.reader = new BeanDefinitionReader();
	}

	/**
	 * getBean 通过读取 BeanDefinition 中的信息，然后，通过反射创建一个实例，并返回
	 * 通过反射机制床架你一个 实例冰饭会， Spring 做法是不会把原始的对象放出去，会用一个  BeanWrapper 进行一次包装
	 * 包装器模式 1. 保留原来的 AOP 关系  2. 我需要对它进行扩展，增强（为后面的 AOP 打下基础）
	 *
	 * @param beanName
	 * @return
	 */
	public Object getBean(String beanName) {
		return null;
	}

	private Object instantionBean(BeanDefinition beanDefinition) {
		String className = beanDefinition.getBeanClassName();
		Object instance = null;
		try {
			if (this.beanDefinitionMap.containsKey(className)) {
				instance = this.beanDefinitionMap.get(className);
			} else {
				Class<?> clazz = Class.forName(className);
				instance = clazz.newInstance();
				this.beanDefinitionMap.put(className, (BeanDefinition) instance);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return instance;
	}
}
