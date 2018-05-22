package com.imooc.test.beanannotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.imooc.beanannotation.javabased.MyDriverManager;
import com.imooc.beanannotation.javabased.Store;
import com.imooc.beanannotation.javabased.StringStore;
import com.imooc.test.base.UnitTestBase;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestJavabased extends UnitTestBase {
	
	public TestJavabased() {
		super("classpath*:spring-beanannotation.xml");
	}

	/**
	 * 泛型注入
	 */
	@Test
	public void test() {
		Store store = super.getBean("stringStore");
//		Store store = super.getBean("stringStore1");
		System.out.println(store.getClass().getName());
	}
	
	@Test
	public void testMyDriverManager() {
		MyDriverManager manager = super.getBean("myDriverManager");
		System.out.println(manager.getClass().getName());
	}
	
	@Test
	public void testScope() {
		Store store = super.getBean("stringStoreScope");
		System.out.println(store.hashCode());

		store = super.getBean("stringStoreScope");
		System.out.println(store.hashCode());
	}
	
	@Test
	public void testG() {
		StringStore store = super.getBean("stringStoreTest1");
	}
	
}
