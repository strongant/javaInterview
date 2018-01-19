package com.strongant.spring.require.noproxy.service.impl;

import com.strongant.spring.require.noproxy.service.ForumService;
import com.strongant.spring.require.noproxy.pojo.PerformanceMonitor;

/**
 * 学习Spring必学的Java基础知识(2)----动态代理
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @see ForumService
 * @since 2017/8/20
 */
public class ForumServiceImpl implements ForumService {

	@Override
	public void removeTopic(int topicId) {
		//①-1开始对该方法进行性能监视
		PerformanceMonitor.begin(
				"com.strongant.spring.require.noproxy.service.impl.ForumServiceImpl.removeTopic");
		System.out.printf("模拟删除Topic记录%d:", topicId);
		try {
			Thread.sleep(20);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		//①-2结束对该方法进行性能监视
		PerformanceMonitor.end();
	}

	@Override
	public void removeForum(int forumId) {
		//②-1开始对该方法进行性能监视
		PerformanceMonitor.begin(
				"com.baobaotao.proxy.ForumServiceImpl. removeForum");
		System.out.println("模拟删除Forum记录:" + forumId);
		try {
			Thread.sleep(40);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		//②-2结束对该方法进行性能监视
		PerformanceMonitor.end();
	}
}
