package org.marco;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.reader.bean.Bean2;
import org.springframework.stereotype.Component;

/**
 * @author Marco
 * @version 1.0
 * @date 2021/7/29 14:18
 */
@Component
public class MyFactoryBean2 implements FactoryBean<Bean2> {
	@Override
	public Bean2 getObject() throws Exception {
		Bean2 bean2 = new Bean2();
		bean2.setWord("你好 工厂 bean");
		return bean2;
	}

	@Override
	public Class<?> getObjectType() {
		return Bean2.class;
	}
}
