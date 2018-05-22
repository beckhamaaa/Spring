package com.imooc.beanannotation.jsr;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

//@Service
//@Named("jsrServie")
//	指定注入的bean名字
@Named
public class JsrServie {
	
//	@Resource
//	@Inject
	private JsrDAO jsrDAO;
	
//	@Resource(name = "jsrDAO")
//	指定注入的bean名字
	@Inject
//	必须指定注入的set方法
	public void setJsrDAO(@Named("jsrDAO") JsrDAO jsrDAO) {
		this.jsrDAO = jsrDAO;
	}
	
	@PostConstruct
//	Spring 初始化
	public void init() {
		System.out.println("JsrServie init.");
	}

	@PreDestroy
//	Spring 销毁
	public void destroy() {
		System.out.println("JsrServie destroy.");
	}

	public void save() {
		jsrDAO.save();
	}
}
