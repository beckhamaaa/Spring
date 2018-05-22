package com.imooc.aop.aspectj.biz;

import org.springframework.stereotype.Service;

import com.imooc.aop.aspectj.MoocMethod;

@Service
public class MoocBiz {

//	自定义的注解 @MoocMethod
	@MoocMethod("MoocBiz save with MoocMethod.")
	public String save(String arg) {
		System.out.println("MoocBiz save : " + arg);
//		throw new RuntimeException(" Save failed!");
		return " Save success!";
	}

}
