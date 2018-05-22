package com.imooc.beanannotation.multibean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("beanInvokera")
//指定bean的名字,默认为类名首字母小写
public class BeanInvoker {

/*
	@Autowired
	private void ApplicationContext applicationContext;
*/

	@Autowired
	private List<BeanInterface> list;
	
	@Autowired
	private Map<String, BeanInterface> map;
	
	@Autowired
	@Qualifier("beanImplOne")
//	对于多个bean，指定注入哪个bean，如继承关系
	private BeanInterface beanInterface;
	
	public void say() {
		if (null != list && 0 != list.size()) {
			System.out.println("list...");
			for (BeanInterface bean : list) {
				System.out.println(bean.getClass().getName());
			}
		} else {
			System.out.println("List<BeanInterface> list is null !!!!!!!!!!");
		}
		
		System.out.println();
		
		if (null != map && 0 != map.size()) {
			System.out.println("map...");
			for (Map.Entry<String, BeanInterface> entry : map.entrySet()) {
				System.out.println(entry.getKey() + "      " + entry.getValue().getClass().getName());
			}
		} else {
			System.out.println("Map<String, BeanInterface> map is null !!!!!!!!!!");
		}
		
		System.out.println();
		if (null != beanInterface) {
			System.out.println(beanInterface.getClass().getName());
		} else {
			System.out.println("beanInterface is null...");
		}
		
		
	}

}
