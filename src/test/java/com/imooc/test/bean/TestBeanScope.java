package com.imooc.test.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.imooc.bean.BeanScope;
import com.imooc.test.base.UnitTestBase;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestBeanScope extends UnitTestBase {
	
	public TestBeanScope() {
		super("classpath*:spring-beanscope.xml");
	}
	
	@Test
	public void testSay() {
		BeanScope beanScope = super.getBean("beanScope");
		beanScope.say();

		BeanScope beanScope2 = super.getBean("beanScope");
		beanScope2.say();
		//返回相同的hashCode时，scope="singleton",否则scope="prototype"
		//当调用不同的@Test方法时，scope="singleton"也返回不同的hashCode,由于junit运行@Test每次都重新加载spring容器
	}
	
	@Test
	public void testSay2() {
		BeanScope beanScope  = super.getBean("beanScope");
		beanScope.say();
	}

}
