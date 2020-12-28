package org.springframework.reader;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.reader.bean.Bean1;
import org.springframework.reader.bean.Bean2;
import org.springframework.reader.bean.IBean;
import org.springframework.reader.config.ApplicationConfig;


/**
 * @author Marco
 * @version 1.0
 * @date 2020/12/8 下午10:01
 */

public class MainApplication {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(ApplicationConfig.class);
		IBean bean1 = applicationContext.getBean(Bean1.class);
		IBean bean2 = applicationContext.getBean(Bean2.class);
		bean1.say();
		bean2.say();

	}

}
