package com.imooc.lifecycle;

import org.springframework.beans.factory.InitializingBean;

public class ExampleInitializingBean implements InitializingBean {
//   Spring 初始化，实现InitializingBean接口

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("interface init");
	}
}
