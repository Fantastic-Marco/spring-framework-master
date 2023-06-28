package org.springframework.reader.factory.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.reader.bean.MyFactoryBeanPojo;
import org.springframework.stereotype.Component;

/**
 * @author Marco
 * @version 1.0
 * @date 2021/7/29 12:54
 */
@Component
public class MyFactoryBean implements FactoryBean<MyFactoryBeanPojo>, InitializingBean,
		ApplicationContextAware {
	private ApplicationContext applicationContext;

	@Override
	public MyFactoryBeanPojo getObject() throws Exception {
		System.out.println("我是FactoryBean 我创建了 Bean1");
		return ()-> System.out.println("我是个被工厂bean创建的bean");
	}

	@Override
	public Class<?> getObjectType() {
		return MyFactoryBeanPojo.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
