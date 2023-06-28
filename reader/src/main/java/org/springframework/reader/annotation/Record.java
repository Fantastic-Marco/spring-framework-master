package org.springframework.reader.annotation;

import java.lang.annotation.*;

/**
 * @author Marco
 * @version 1.0
 * @date 2022/8/2 16:04
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE_USE})
@Inherited
public @interface Record {
	String value();
}
