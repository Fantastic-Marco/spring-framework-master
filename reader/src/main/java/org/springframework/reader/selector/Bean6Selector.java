package org.springframework.reader.selector;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.reader.annotation.Record;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Marco
 * @version 1.0
 * @date 2022/7/27 16:52
 * 这个例子将会教你，如果你声明了一个注解
 * 并且将这个注解应用到一个非bean身上，怎么把被注解应用的类加载到容器内
 */
public class Bean6Selector implements ImportSelector {
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

	/**
	 * Select and return the names of which class(es) should be imported based on
	 * the {@link AnnotationMetadata} of the importing @{@link Configuration} class.
	 *
	 * @param importingClassMetadata
	 * @return the class names, or an empty array if none
	 * 根据导入 @{@link Configuration} 类的 {@link AnnotationMetadata} 选择并返回应导入的类的名称。
	 * @return 类名，如果没有则返回一个空数组
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
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
		Set<String> recordClassName = Optional.ofNullable(getBasePackage())
				.orElse(Collections.emptySet())
				.stream()
				.map(scanner::findCandidateComponents)
				.flatMap(Collection::stream)
				.map(BeanDefinition::getBeanClassName)
				.collect(Collectors.toSet());
		String[] classNames = new String[recordClassName.size()];
		recordClassName.toArray(classNames);
		return classNames;
	}

	/**
	 * Return a predicate for excluding classes from the import candidates, to be
	 * transitively applied to all classes found through this selector's imports.
	 * <p>If this predicate returns {@code true} for a given fully-qualified
	 * class name, said class will not be considered as an imported configuration
	 * class, bypassing class file loading as well as metadata introspection.
	 *
	 * @return the filter predicate for fully-qualified candidate class names
	 * of transitively imported configuration classes, or {@code null} if none
	 * @return 过滤谓词用于传递导入的配置类的完全限定候选类名称，如果没有则 {@code null}
	 * @since 5.2.4
	 * 返回一个从导入候选中排除类的谓词，以传递地应用于通过此选择器的导入找到的所有类。
	 * 如果此谓词为给定的完全限定类名返回 {@code true}，则该类将不被视为导入的配置类，绕过类文件加载以及元数据自省。
	 * @since 5.2.4
	 */
	@Override
	public Predicate<String> getExclusionFilter() {
		return ImportSelector.super.getExclusionFilter();
	}
}
