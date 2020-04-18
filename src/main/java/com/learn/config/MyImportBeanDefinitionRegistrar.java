package com.learn.config;

import com.learn.bean.Blue;
import com.learn.bean.Yellow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
        if (!registry.containsBeanDefinition("blue")) {
            RootBeanDefinition blue = new RootBeanDefinition(Blue.class);
            registry.registerBeanDefinition("blue",blue );
        }
        if (!registry.containsBeanDefinition("yellow")) {
            RootBeanDefinition yellow = new RootBeanDefinition(Yellow.class);
            registry.registerBeanDefinition("yellow",yellow );
        }

    }
}
