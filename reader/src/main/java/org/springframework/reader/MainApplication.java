package org.springframework.reader;

import org.marco.TestConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.reader.bean.*;
import org.springframework.reader.config.ApplicationConfig;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @author Marco
 * @version 1.0
 * @date 2020/12/8 下午10:01
 */

public class MainApplication {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(ApplicationConfig.class);
//		IBean bean1 = (IBean) applicationContext.getBean("bean1");
//		IBean bean2 = (IBean) applicationContext.getBean("bean2");
		Bean2 bean2 = applicationContext.getBean(Bean2.class);
//		Bean3 bean3 = applicationContext.getBean(Bean3.class);
		Bean6 bean6 = applicationContext.getBean(Bean6.class);
//		MyFactoryBeanPojo bean7 = applicationContext.getBean(MyFactoryBeanPojo.class);
//		Bean4 bean4 = applicationContext.getBean(Bean4.class);
		Bean5 bean5 = applicationContext.getBean(Bean5.class);
//		bean1.say();
		bean2.say();
//		bean3.say();
//		bean4.say();
		bean5.say();
		bean6.say();
//		bean7.say();


	}

}
