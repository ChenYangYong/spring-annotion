package com.learn.config;

import com.learn.bean.Cat;
import com.learn.bean.Dog;
import com.learn.bean.Red;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{
                Cat.class.getName(),
                Dog.class.getName()
        };
    }
}
