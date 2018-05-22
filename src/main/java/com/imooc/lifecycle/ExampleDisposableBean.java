package com.imooc.lifecycle;

import org.springframework.beans.factory.DisposableBean;

public class ExampleDisposableBean implements DisposableBean {
//   Spring 销毁，实现DisposableBean接口
	@Override
	public void destroy() throws Exception {
		System.out.println("interface destroy");
	}

}

