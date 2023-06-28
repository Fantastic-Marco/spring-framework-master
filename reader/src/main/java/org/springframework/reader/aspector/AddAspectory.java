package org.springframework.reader.aspector;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * @author Marco
 * @version 1.0
 * @date 2021/1/14 15:40
 */
@Aspect
@Component
public class AddAspectory {

	@Pointcut(value = "execution(* org.springframework.reader.bean.Bean2.add(..))")
	public void pointcut(){}

	@Around(value = "pointcut() && args(a,b)")
	public int add(ProceedingJoinPoint joinPoint,Integer a,Integer b){
		System.out.println("a: "+ a);
		System.out.println("b: "+ b);
		Object[] args = joinPoint.getArgs();
		Integer arg1 = (Integer) args[0];
		Integer arg2 = (Integer) args[1];
		if (arg1 < 0 || arg2 < 0){
			return 0;
		}else{
			try {
				System.out.println("我是切面");
				return (int) joinPoint.proceed(args);
			} catch (Throwable throwable) {
				throwable.printStackTrace();
				return -1;
			}
		}
	}

}
