package com.imooc.autowiring;

/**
 * xml自动装配,必须提供set方法，构造方法自动配置不用提供
 */
public class AutoWiringService {
	
	private AutoWiringDAO autoWiringDAO;

//	构造方法自动装配
	public AutoWiringService(AutoWiringDAO autoWiringDAO) {
		System.out.println("AutoWiringService constructor");
		this.autoWiringDAO = autoWiringDAO;
	}

//	普通属性自动装配
//	public void setAutoWiringDAO(AutoWiringDAO autoWiringDAO) {
//		System.out.println("setAutoWiringDAO");
//		this.autoWiringDAO = autoWiringDAO;
//	}
	
	public void say(String word) {
		this.autoWiringDAO.say(word);
	}
}
