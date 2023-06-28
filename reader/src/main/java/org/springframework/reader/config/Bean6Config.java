package org.springframework.reader.config;

import org.springframework.context.annotation.Bean;
import org.springframework.reader.aspector.Bean6MethodInterceptor;

/**
 * @author Marco
 * @version 1.0
 * @date 2022/8/2 16:20
 */
public class Bean6Config {

	@Bean
	public Bean6MethodInterceptor bean6MethodInterceptor() {
		return new Bean6MethodInterceptor();
	}

}
