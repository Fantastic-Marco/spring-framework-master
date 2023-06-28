package org.springframework.reader.bean;

import org.springframework.reader.annotation.Record;

/**
 * @author Marco
 * @version 1.0
 * @date 2021/4/8 17:06
 */
@Record("B")
public class Bean6 {

	@Record("老王")
	public void say() {
		System.out.println("bean6 say fuck");
	}
}
