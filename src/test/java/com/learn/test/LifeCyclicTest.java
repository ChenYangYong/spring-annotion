package com.learn.test;

import com.learn.config.MainConfig2;
import com.learn.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCyclicTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
    @Test
    public void testLifeCycle(){
        applicationContext.close();
    }
}
