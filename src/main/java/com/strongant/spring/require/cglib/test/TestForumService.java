package com.strongant.spring.require.cglib.test;

import com.strongant.spring.require.cglib.proxy.CglibProxy;
import com.strongant.spring.require.jdkdynamicproxy.service.impl.ForumServiceImpl;

import java.awt.image.BufferedImage;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class TestForumService {
	public static void main(String[] args) {
		CglibProxy proxy = new CglibProxy();
		ForumServiceImpl forumService = (ForumServiceImpl )proxy.getProxy(ForumServiceImpl.class);
		forumService.removeForum(10);
		forumService.removeTopic(1023);
	}
}
