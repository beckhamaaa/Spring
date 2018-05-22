package com.imooc.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
//java代码声明Aspectj切面
@Configuration
@EnableAspectJAutoProxy
public class MoocAspect {
	
	@Pointcut("execution(* com.imooc.aop.aspectj.biz.*Biz.*(..))")
	public void pointcut() {}  //pointcut 切入点标记

	//	匹配biz包下的所有类
	@Pointcut("within(com.imooc.aop.aspectj.biz.*)")
	public void bizPointcut() {}
	
	@Before("pointcut()")
	public void before() {
		System.out.println("Before.");
	}

	// Advice传递参数，@Before(中的args(args))要与方法参数一致
	@Before("pointcut() && args(arg)")
	public void beforeWithParam(String arg) {
		System.out.println("BeforeWithParam." + arg);
	}

	@Before("pointcut() && @annotation(moocMethod)")
	public void beforeWithAnnotaion(MoocMethod moocMethod) {
//		moocMethod.value() 获取自定义注解moocMethod的值
		System.out.println("BeforeWithAnnotation." + moocMethod.value());
	}

//	argNames属性，可以用来指定所注解的方法的参数名
	@Before(value="pointcut()",argNames = "bean,auditable")
	public void beforeArgNames(Object bean,Object auditable) {
		System.out.println("BeforeArgNames.");
	}

	@AfterReturning(pointcut="bizPointcut()", returning="returnValue")
	public void afterReturning(Object returnValue) {
		System.out.println("AfterReturning : " + returnValue);
	}

	@AfterThrowing(pointcut="pointcut()", throwing="e")
	public void afterThrowing(RuntimeException e) {
		System.out.println("AfterThrowing : " + e.getMessage());
	}

	@After("pointcut()")
	public void after() {
		System.out.println("After.");
	}

	@Around("pointcut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Around 1.");
		Object obj = pjp.proceed();
		System.out.println("Around 2.");
		System.out.println("Around : " + obj);  //Save success!
		return obj;
	}



}


