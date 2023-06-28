package org.springframework.reader.registrar;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.reader.annotation.Record;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Marco
 * @version 1.0
 * @date 2021/7/30 17:25
 */
public class MyRegistrar implements ImportBeanDefinitionRegistrar {

	public Set<String> getBasePackage() {
		try {
			ClassPathResource resource = new ClassPathResource("application.properties");
			Properties properties = PropertiesLoaderUtils.loadProperties(resource);
			String basePackageStr = properties.getProperty("record.scan.packages");
			return Arrays.stream(basePackageStr.split(","))
					.peek(System.out::println)
					.collect(Collectors.toSet());
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptySet();
		}
	}

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry, false);
		TypeFilter typeFilter = (metadataReader, metadataReaderFactory) -> {
			AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
			System.out.println("Bean6Selector scan -> " + annotationMetadata.getClassName());
			Set<String> annotationTypes = annotationMetadata.getAnnotationTypes();
			if (annotationTypes == null || annotationTypes.size() == 0) {
				return false;
			}
			return annotationTypes.contains(Record.class.getName());
		};
		scanner.addIncludeFilter(typeFilter);
		Optional.ofNullable(getBasePackage())
				.orElse(Collections.emptySet())
				.stream()
				.map(scanner::findCandidateComponents)
				.flatMap(Collection::stream)
				.forEach(beanDefinition -> {
					registry.registerBeanDefinition(beanDefinition.getBeanClassName(), beanDefinition);
				});
	}
}
