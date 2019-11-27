package com.david.rpcproxy.anno;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @version $Id: null.java, v 1.0 2019/11/26 5:34 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class DemoImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        AnnotationTypeFilter annotationTypeFilter = new AnnotationTypeFilter(DemoRpcClient.class);

        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry);
        scanner.addIncludeFilter(annotationTypeFilter);

        Set<String> basePackages = new HashSet<>();
        Map<String, Object> properties = importingClassMetadata.getAnnotationAttributes(EnableDemoAnno.class.getCanonicalName());
        for(String basePackage: (String[]) properties.get("basePackages")){
            basePackages.add(basePackage);
        }
        scanner.scan();

    }
}
