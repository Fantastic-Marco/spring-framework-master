/*
 * Copyright 2002-2020 the original author or authors.
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

package org.springframework.core.metrics;

/**
 * Instruments the application startup phase using {@link StartupStep steps}.
 * <p>The core container and its infrastructure components can use the {@code ApplicationStartup}
 * to mark steps during the application startup and collect data about the execution context
 * or their processing time.
 * 使用 {@link StartupStep steps} 指令使程序进入启动阶段
 * 核心容器和基础组件可以使用 {@code ApplicationStartup} 在程序启动期间标记步骤并收集有关执行的上下文数据
 * 或者是执行时间
 *
 * @author Brian Clozel
 * @since 5.3
 */
public interface ApplicationStartup {

	/**
	 * Default "no op" {@code ApplicationStartup} implementation.
	 * <p>This variant is designed for minimal overhead and does not record data.
	 * 默认 无操作 {@code ApplicationStartup} 的实现
	 * 这个变体是为最小的开销而设计的，不记录数据
	 */
	ApplicationStartup DEFAULT = new DefaultApplicationStartup();

	/**
	 * Create a new step and marks its beginning.
	 * <p>A step name describes the current action or phase. This technical
	 * name should be "." namespaced and can be reused to describe other instances of
	 * the same step during application startup.
	 * 创建一个新的步骤并且标记其为已启动
	 * 步骤名称描述当前操作或阶段，这个技术命名应该为"."命名空间
	 * 并且可以被重用于程序启动期间其他相同步骤的实例
	 * @param name the step name	步骤名
	 */
	StartupStep start(String name);

}
