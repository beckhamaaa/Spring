package com.imooc.beanannotation.javabased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
//@ImportResource("classpath:config.xml")
//读取配置文件
public class StoreConfig {
	
//	@Value("${url}")
////	获得配置文件中的属性
//	private String url;
//
////	@Value("${username}")
////	默认为计算机用户名
//	@Value("${jdbc.username}")
//	private String username;
//
//	@Value("${password}")
//	private String password;

//	@Bean
//	public MyDriverManager myDriverManager() {
//		return new MyDriverManager(url, username, password);
//	}
	
	@Bean(initMethod = "init",destroyMethod = "destroy")
//	spring 初始化和销毁方法
	public Store stringStore1() {
		return new StringStore();
	}
	
	@Bean
	@Scope(value="prototype" , proxyMode = ScopedProxyMode.TARGET_CLASS)
//	proxyMode = ScopedProxyMode.TARGET_CLASS aa
//	指定bean作用域
	public Store stringStoreScope() {
		return new StringStore();
	}

	@Autowired
//	泛型注入
	private Store<String> s1;

	@Autowired
	private Store<Integer> s2;
	
	@Bean
	public StringStore stringStore() {
		return new StringStore();
	}
	@Bean
	public IntegerStore integerStore() {
		return new IntegerStore();
	}
	
	@Bean(name = "stringStoreTest1")
//	指定bean的名字，默认为方法名
	public Store stringStoreTest() {
		System.out.println("s1 : " + s1.getClass().getName());
		System.out.println("s2 : " + s2.getClass().getName());
		return new StringStore();
	}

}
