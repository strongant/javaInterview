package com.strongant.spring.require.jdkdynamicproxy.service.impl;

import com.strongant.spring.require.jdkdynamicproxy.service.ForumService;
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
		System.out.printf("模拟删除Topic记录%d:", topicId);
		try {
			Thread.sleep(20);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void removeForum(int forumId) {
		System.out.println("模拟删除Forum记录:" + forumId);
		try {
			Thread.sleep(40);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
