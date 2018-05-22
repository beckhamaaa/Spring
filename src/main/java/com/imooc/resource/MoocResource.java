package com.imooc.resource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class MoocResource implements ApplicationContextAware {
//	实现ApplicationContextAware接口
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	public void resource() throws IOException {

		//获得资源文件
		//无前缀
//		Resource resource = applicationContext.getResource("config.txt");
//		resources目录中的访问路径为config.txt和classpaht:config.txt
		//classpath
//		Resource resource = applicationContext.getResource("classpath:config.txt");
		//file
//		Resource resource = applicationContext.getResource("file:C://config.txt");
		//http
		Resource resource = applicationContext.getResource("https://www.baidu.com");
		//获得资源文件名
		System.out.println(resource.getFilename());
		//获得资源文件长度
		System.out.println(resource.contentLength());
	}



}

