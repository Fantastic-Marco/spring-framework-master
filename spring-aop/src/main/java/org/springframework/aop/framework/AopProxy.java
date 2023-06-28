/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.aop.framework;

import org.springframework.lang.Nullable;

/**
 * Delegate interface for a configured AOP proxy, allowing for the creation
 * of actual proxy objects.
 * 配置的 AOP 代理的委托接口，允许创建实际的代理对象。
 * <p>Out-of-the-box implementations are available for JDK dynamic proxies
 * and for CGLIB proxies, as applied by {@link DefaultAopProxyFactory}.
 * 开箱即用的实现可用于 JDK 动态代理和 CGLIB 代理，由 {@link DefaultAopProxyFactory} 应用
 * JDK动态代理和CGLib动态代理的不同
 * JDK动态代理
 * 		JDK动态代理需要实现invocationHandler接口
 * 		通过为Proxy类指定ClassLoader对象和一组interface来创建动态代理；
 *		通过反射机制获取动态代理类的构造函数，其唯一参数类型就是调用处理器接口类型；
 *		通过构造函数创建动态代理类实例，构造时调用处理器对象作为参数参入；
 *		JDK动态代理是面向接口的代理模式，如果被代理目标没有接口那么Spring也无能为力，
 *		Spring通过Java的反射机制生产被代理接口的新的匿名实现类，重写了其中AOP的增强方法。
 *CGLib代理
 * 		利用ASM开源包，对代理对象类的class文件加载进来，通过修改其字节码生成子类来处理。
 * 		CGLib动态代理是通过字节码底层继承要代理类来实现，因此如果被代理类被final关键字所修饰，会失败。
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @see DefaultAopProxyFactory
 */
public interface AopProxy {

	/**
	 * Create a new proxy object.
	 * <p>Uses the AopProxy's default class loader (if necessary for proxy creation):
	 * usually, the thread context class loader.
	 * @return the new proxy object (never {@code null})
	 * @see Thread#getContextClassLoader()
	 */
	Object getProxy();

	/**
	 * Create a new proxy object.
	 * <p>Uses the given class loader (if necessary for proxy creation).
	 * {@code null} will simply be passed down and thus lead to the low-level
	 * proxy facility's default, which is usually different from the default chosen
	 * by the AopProxy implementation's {@link #getProxy()} method.
	 * @param classLoader the class loader to create the proxy with
	 * (or {@code null} for the low-level proxy facility's default)
	 * @return the new proxy object (never {@code null})
	 */
	Object getProxy(@Nullable ClassLoader classLoader);

}
