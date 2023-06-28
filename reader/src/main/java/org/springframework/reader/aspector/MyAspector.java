package org.springframework.reader.aspector;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author Marco
 * @version 1.0
 * @date 2020/12/22 下午10:13
 */
//@Aspect
//@Component
public class MyAspector {

	@Pointcut("execution(* org.springframework.reader.bean.Bean1.say(..))")
	public void pointCut(){}


	@Before(value = "pointCut()")
	public void beforeBean1Fuck(){
		System.out.println("全单位注意！！！ bean们 要开始说脏话了");
	}

	@After(value = "pointCut()")
	public void afterBean1Fuck(){
		System.out.println("没素质，还是讲了脏话");
	}

	@Around(value = "pointCut()")
	public void aroundBean1Fuck(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("切面：脏话管理委员会-> 被监听对象："+ joinPoint.getTarget().getClass().getCanonicalName());
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		System.out.println("切面：脏话管理委员会-> 被监听方法：" + signature.getMethod().getName());
		int i = new Random().nextInt(10);
		if (i %2 == 0){
			System.out.println("切面：脏话管理委员会-> 饶你一次，说吧");
			joinPoint.proceed();
		}else{
			System.out.println("切面：脏话管理委员会-> 没收讲脏话工具");
			return;
		}
	}
}
