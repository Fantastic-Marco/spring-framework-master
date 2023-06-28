package org.springframework.reader.invocation;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.reader.bean.Bean2;

import java.lang.reflect.Method;

/**
 * @author Marco
 * @version 1.0
 * @date 2021/2/5 14:27
 */
public class MyInvocation implements InvocationHandler {

	@Override
	public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
		if (o.getClass().getName().equals(Bean2.class.getName())) {
			return method.invoke(o, objects);
		}else{
			System.out.println("Invacation 非目标方法");
			return null;
		}
	}

}
