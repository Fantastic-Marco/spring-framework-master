package org.marco;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author Marco
 * @version 1.0
 * @date 2021/7/22 21:34
 */
@Configuration
public class TestConfig {

	@PostConstruct
	public void say(){
		System.out.println("TestConfig: 我被初始化了");
	}

}
