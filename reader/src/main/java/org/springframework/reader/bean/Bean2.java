package org.springframework.reader.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Marco
 * @version 1.0
 * @date 2020/12/8 下午10:02
 */
@Component
public class Bean2 implements IBean {
//	@Autowired
//	private Bean1 bean;

	@Override
	public void say(){
		System.out.println("bean2 say fuck");
	}
}
