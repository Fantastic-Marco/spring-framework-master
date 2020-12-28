package org.springframework.reader.aspector;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Marco
 * @version 1.0
 * @date 2020/12/22 下午10:13
 */
@Aspect
public class MyAspector {


	@Before(value = "execution(* org.springframework.reader.bean.Bean1.say(..))")
	public void beforeBean1Fuck(JoinPoint joinPoint){
		System.out.println("全单位注意！！！ bean们 要开始说脏话了");
	}
}
