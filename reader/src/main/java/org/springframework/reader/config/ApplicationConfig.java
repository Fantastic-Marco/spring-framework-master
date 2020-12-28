package org.springframework.reader.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Marco
 * @version 1.0
 * @date 2020/12/28 下午11:48
 */
@ComponentScan(basePackages = {"org.springframework.reader"})
@EnableAspectJAutoProxy
@Configuration
public class ApplicationConfig {
}
