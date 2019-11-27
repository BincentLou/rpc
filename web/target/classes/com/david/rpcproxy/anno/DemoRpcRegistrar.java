package com.david.rpcproxy.anno;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @version $Id: null.java, v 1.0 2019/11/21 7:14 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:
 * @since 1.0
 **/
public class DemoRpcRegistrar implements ImportBeanDefinitionRegistrar , EnvironmentAware , ResourceLoaderAware {

    private Environment environment;

    private ResourceLoader resourceLoader;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public DemoRpcRegistrar() {
        System.out.println("新建DemoRpcRegistrar");
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        System.out.println("开始扫描");
        registerRpcClients(importingClassMetadata, registry);
    }


    public void registerRpcClients(AnnotationMetadata metadata,
                                     BeanDefinitionRegistry registry) {
        ClassPathScanningCandidateComponentProvider scanner = getScanner();
        scanner.setResourceLoader(this.resourceLoader);
        Set<String> basePackages;
        AnnotationTypeFilter annotationTypeFilter = new AnnotationTypeFilter(
                DemoRpcClient.class);
        scanner.addIncludeFilter(annotationTypeFilter);
        basePackages = new HashSet<>();
        Map<String, Object> attrs = metadata
                .getAnnotationAttributes(EnableDemoAnno.class.getName());
        // TODO 通过metadata获取当前目录
//        getBasePackages(metadata);
        basePackages.add("com.david.rpcproxy");
        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidateComponents = scanner
                    .findCandidateComponents(basePackage);
            System.out.println("扫描出"+candidateComponents.size()+"个demorpc");
            for (BeanDefinition candidateComponent : candidateComponents) {
                if (candidateComponent instanceof AnnotatedBeanDefinition) {
                    // verify annotated class is an interface
                    AnnotatedBeanDefinition beanDefinition = (AnnotatedBeanDefinition) candidateComponent;
                    AnnotationMetadata annotationMetadata = beanDefinition.getMetadata();
                    Assert.isTrue(annotationMetadata.isInterface(),
                            "@DemonAnnotation can only be specified on an interface");

                    Map<String, Object> attributes = annotationMetadata
                            .getAnnotationAttributes(
                                    DemoRpcClient.class.getCanonicalName());
                    registerRpcClient(registry, annotationMetadata, attributes);
                }
            }
        }
    }


    private void registerRpcClient(BeanDefinitionRegistry registry,
                                   AnnotationMetadata annotationMetadata, Map<String, Object> attributes) {
        String className = annotationMetadata.getClassName();
        BeanDefinitionBuilder definition = BeanDefinitionBuilder
                .genericBeanDefinition(DemoProxyFactoryBean.class);
        definition.addPropertyValue("url", getUrl(attributes));
        String name = getName(attributes);
        definition.addPropertyValue("name", name);
        definition.addPropertyValue("type", className);
        definition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);

        String alias = name + "DemoRPC";
        AbstractBeanDefinition beanDefinition = definition.getBeanDefinition();

        boolean primary = (Boolean)attributes.get("primary"); // has a default, won't be null

        beanDefinition.setPrimary(primary);

        BeanDefinitionHolder holder = new BeanDefinitionHolder(beanDefinition, className,
                new String[] { alias });
        BeanDefinitionReaderUtils.registerBeanDefinition(holder, registry);
    }

    private Object getUrl(Map<String, Object> attributes) {
        return (String) attributes.get("url");
    }

    private String getName(Map<String, Object> attributes) {
        return (String) attributes.get("name");
    }

    protected ClassPathScanningCandidateComponentProvider getScanner() {
        return new ClassPathScanningCandidateComponentProvider(false, this.environment) {
            @Override
            protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
                boolean isCandidate = false;
                if (beanDefinition.getMetadata().isIndependent()) {
                    if (!beanDefinition.getMetadata().isAnnotation()) {
                        isCandidate = true;
                    }
                }
                return isCandidate;
            }
        };
    }

    /**
     * 获取扫描路径
     * @param importingClassMetadata
     * @return
     */
    protected Set<String> getBasePackages(AnnotationMetadata importingClassMetadata) {
        Map<String, Object> attributes = importingClassMetadata
                .getAnnotationAttributes(DemoRpcBean.class.getCanonicalName());

        Set<String> basePackages = new HashSet<>();
        for (String pkg : (String[]) attributes.get("value")) {
            if (StringUtils.hasText(pkg)) {
                basePackages.add(pkg);
            }
        }
        for (String pkg : (String[]) attributes.get("basePackages")) {
            if (StringUtils.hasText(pkg)) {
                basePackages.add(pkg);
            }
        }
        for (Class<?> clazz : (Class[]) attributes.get("basePackageClasses")) {
            basePackages.add(ClassUtils.getPackageName(clazz));
        }

        if (basePackages.isEmpty()) {
            basePackages.add(
                    ClassUtils.getPackageName(importingClassMetadata.getClassName()));
        }
        return basePackages;
    }

}
