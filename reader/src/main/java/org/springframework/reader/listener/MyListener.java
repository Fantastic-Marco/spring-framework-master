package org.springframework.reader.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author Marco
 * @version 1.0
 * @date 2020/12/28 下午11:31
 */
@Component
public class MyListener implements ApplicationListener<ApplicationEvent> {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("MyListener: 程序启动啦，我是程序监听器");
	}
}
