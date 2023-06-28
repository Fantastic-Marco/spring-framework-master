package org.springframework.reader.processor.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.reader.bean.Bean2;
import org.springframework.reader.bean.IBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author Marco
 * @version 1.0
 * @date 2021/2/4 15:59
 */
//@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof IBean) {
			System.out.println(beanName + "在你初始化之前我就执行了，意不意外");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof IBean) {
			System.out.println(beanName + "在你初始化后我又执行了，意不意外");
			Bean2 bean2 = (Bean2) bean;
			Class<? extends Bean2> clazz = bean2.getClass();
			Field[] declaredFields = clazz.getDeclaredFields();
			Arrays.stream(declaredFields).filter(f -> f.getName().equals("word"))
					.findFirst().ifPresent(f -> {
				f.setAccessible(true);
				try {
					f.set(bean2, clazz.getName() + " -> 没想到吧，这个值我是注入的");
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			});
		}
		return bean;
	}
}
