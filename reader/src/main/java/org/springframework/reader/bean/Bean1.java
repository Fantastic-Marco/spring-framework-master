package org.springframework.reader.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Marco
 * @version 1.0
 * @date 2020/12/8 下午10:02
 */
@Component
public class Bean1 {
	@Autowired
	private Bean2 bean;

	public void say(){
		System.out.println("bean1 say fuck");
	}

	@PostConstruct
	public void afterInit(){
		System.out.println("bean1 say I am good feeling after init");
	}
}
