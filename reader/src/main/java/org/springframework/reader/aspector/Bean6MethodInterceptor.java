package org.springframework.reader.aspector;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.context.annotation.Bean;
import org.springframework.reader.annotation.Record;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Marco
 * @version 1.0
 * @date 2022/8/2 16:02
 */
public class Bean6MethodInterceptor implements MethodInterceptor {
	/**
	 * Implement this method to perform extra treatments before and
	 * after the invocation. Polite implementations would certainly
	 * like to invoke {@link Joinpoint#proceed()}.
	 *
	 * @param invocation the method invocation joinpoint
	 * @return the result of the call to {@link Joinpoint#proceed()};
	 * might be intercepted by the interceptor
	 * @return 调用结果 {@link Joinpointproceed()};
	 * @throws Throwable if the interceptors or the target object
	 *                   throws an exception
	 *                   <p>
	 *                   实现此方法以在调用之前和之后执行额外的处理。
	 *                   礼貌的实现肯定会调用 {@link Joinpoint Proceed()}。
	 * @throws Throwable 如果拦截器或目标对象抛出异常，可能会被拦截器拦截
	 */
	@Nullable
	@Override
	public Object invoke(@Nonnull MethodInvocation invocation) throws Throwable {
		Method method = invocation.getMethod();
		Record annotation = method.getAnnotation(Record.class);
		Object result = null;
		if (Objects.nonNull(annotation)) {
			String name = annotation.value();
			try {
				Object targetObject = invocation.getThis();
				Object[] arguments = invocation.getArguments();
				System.out.println("before:" + name + " method: " + method.getName());
				result = method.invoke(targetObject, arguments);
				System.out.println("after:" + name + " method: " + method.getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
