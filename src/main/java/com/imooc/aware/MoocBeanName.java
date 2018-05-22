package com.imooc.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class MoocBeanName implements BeanNameAware, ApplicationContextAware {
	//     实现 BeanNameAware, ApplicationContextAware接口
	//注入beanName 	<bean id="moocBeanName" class="com.imooc.aware.MoocBeanName"></bean>
	private String beanName;
	
	@Override
	public void setBeanName(String name) {
		this.beanName=name;
		System.out.println("MoocBeanName : " + name);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
//		this.beanName 获得bean的名字
		System.out.println("MoocBeanName setApplicationContext : " + applicationContext.getBean(this.beanName).hashCode());

	}

}
