package org.springframework.reader.processor.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.reader.bean.Bean1;
import org.springframework.reader.bean.Bean2;
import org.springframework.stereotype.Component;

/**
 * @author Marco
 * @version 1.0
 * @date 2021/3/20 11:18
 */
@Component
public class MyBeanFactoryPostProcesor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//		System.out.println("bean工厂创建");
//		BeanDefinition bean1 = beanFactory.getBeanDefinition("bean1");
//		bean1.setBeanClassName("bean2");
//		bean1.setBeanClassName(Bean2.class.getName());
//		BeanDefinition bean2 = beanFactory.getBeanDefinition("bean2");
//		bean2.setBeanClassName("bean1");
//		bean2.setBeanClassName(Bean1.class.getName());
	}
}
