package com.web;

import com.web.config.RootConfig;
import com.web.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *     关于 AbstractAnnotationConfigDispatcherServletInitializer
 *
 *     各位好，如果以上介绍不过瘾，这里是复杂来说…
 *
 *     在 Servlet 3.0 环境下，Servlet 容器会在 classpath 下搜索实现了 javax.servlet
 *     .ServletContainerInitializer 接口的任何类，找到之后用它来初始化 Servlet 容器。
 *
 *     Spring 实现了以上接口，实现类叫做 SpringServletContainerInitializer， 它会依次搜寻实现了
 *     WebApplicationInitializer的任何类，并委派这个类实现配置。之后，
 *     Spring 3.2 开始引入一个简易的 WebApplicationInitializer 实现类，
 *     这就是 AbstractAnnotationConfigDispatcherServletInitializer。
 *
 *     所以 SpittrWebAppInitializer 继承 AbstractAnnotationConfigDispatcherServletInitializer之后，也就是间接实现了 WebApplicationInitializer，在 Servlet 3.0 容器中，它会被自动搜索到，被用来配置 servlet 上下文。
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer  {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

}
