package org.springframework.reader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.reader.bean.Bean1;
import org.springframework.reader.bean.Bean2;


/**
 * @author Marco
 * @version 1.0
 * @date 2020/12/8 下午10:01
 */
public class MainApplication {

	public static void main(String[] args) throws Exception {
		Logger log4j = Logger.getLogger(MainApplication.class);
		Log logger = LogFactory.getLog(MainApplication.class);
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext("org.springframework.reader.bean");
		System.out.println("trace:" + logger.isTraceEnabled());
		System.out.println("debug:" + logger.isDebugEnabled());
		System.out.println("info:" + logger.isInfoEnabled());

		System.out.println("trace:" + log4j.isTraceEnabled());
		System.out.println("debug:" + log4j.isDebugEnabled());
		System.out.println("info:" + log4j.isInfoEnabled());
		log4j.trace("初始化完成");
		Bean1 bean1 = applicationContext.getBean(Bean1.class);
		Bean2 bean2 = applicationContext.getBean(Bean2.class);
		bean1.say();
		bean2.say();

	}

}
