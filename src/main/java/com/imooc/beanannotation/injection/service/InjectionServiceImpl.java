package com.imooc.beanannotation.injection.service;

import com.imooc.beanannotation.injection.dao.InjectionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//声明Service层
@Service
public class InjectionServiceImpl implements InjectionService {

	  @Autowired
	//@Autowired 用于属性上，不用set方法
	private InjectionDAO injectionDAO;
	
	//	@Autowired
	//@Autowired 用于构造方法上
	/*public InjectionServiceImpl(InjectionDAO injectionDAO) {
		this.injectionDAO = injectionDAO;
	}*/
	
//	@Autowired
//	//@Autowired 用于set方法上
//	public void setInjectionDAO(InjectionDAO injectionDAO) {
//		this.injectionDAO = injectionDAO;
//	}


	public void save(String arg) {
		//模拟业务操作
		System.out.println("Service接收参数：" + arg);
		arg = arg + ":" + this.hashCode();
		injectionDAO.save(arg);
	}
	
}
