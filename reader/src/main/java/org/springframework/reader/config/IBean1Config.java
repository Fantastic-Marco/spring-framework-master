package org.springframework.reader.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

/**
 * @author Marco
 * @version 1.0
 * @date 2021/4/8 17:07
 */
public class IBean1Config implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{"org.springframework.reader.bean.Bean4","org.springframework.reader.bean.Bean5"};
	}

	@Override
	public Predicate<String> getExclusionFilter() {
		Predicate<String> predicate = s -> !s.contains("2");
		return predicate;
	}
}
