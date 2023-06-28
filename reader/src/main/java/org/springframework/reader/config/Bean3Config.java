package org.springframework.reader.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.reader.bean.Bean3;
import org.springframework.reader.registrar.MyRegistrar;

/**
 * @author Marco
 * @version 1.0
 * @date 2021/4/8 17:02
 */
@Import({Bean3.class,IBean1Config.class, MyRegistrar.class})
@Configuration
public class Bean3Config {



}
