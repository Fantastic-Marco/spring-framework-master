package org.springframework.reader.bean;

import org.springframework.reader.annotation.Record;

/**
 * @author Marco
 * @version 1.0
 * @date 2021/4/8 17:06
 */
@Record("A")
public class Bean5{

	@Record("张三")
	public void say() {
		System.out.println("bean5 say fuck");
	}
}
