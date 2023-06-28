package org.springframework.reader.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.reader.bean.Bean2;
import org.springframework.reader.selector.Bean6Selector;

/**
 * @author Marco
 * @version 1.0
 * @date 2020/12/28 下午11:48
 */
//@Import(Bean3Config.class)
//@Import(Bean6Selector.class)
@ComponentScan(basePackages = {"org.springframework.reader","org.marco"})
@EnableAspectJAutoProxy
@Configuration
public class ApplicationConfig {
}
