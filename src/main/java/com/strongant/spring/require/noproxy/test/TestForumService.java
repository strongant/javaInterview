package com.strongant.spring.require.noproxy.test;

import com.strongant.spring.require.noproxy.service.ForumService;
import com.strongant.spring.require.noproxy.service.impl.ForumServiceImpl;

/**
 *  方法调用性能监控测试
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @see ForumService
 * @since 2017/8/20
 */
public class TestForumService {
	public static void main(String[] args) {
		ForumService forumService = new ForumServiceImpl();
		forumService.removeForum(10);
		forumService.removeTopic(1012);
	}
}
