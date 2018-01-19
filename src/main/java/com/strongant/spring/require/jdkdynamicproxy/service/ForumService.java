package com.strongant.spring.require.jdkdynamicproxy.service;

/**
 * 没有使用JDK动态代理 带有横切逻辑的接口
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public interface ForumService {
	void removeTopic(int topicId);

	void removeForum(int forumId);
}
