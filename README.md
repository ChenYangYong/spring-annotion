# spring-annotion
https://blog.csdn.net/chai19921206/article/details/80688155

关于 AbstractAnnotationConfigDispatcherServletInitializer
在 Servlet 3.0 环境下，Servlet 容器会在 classpath 下搜索实现了 
javax.servlet .ServletContainerInitializer 接口的任何类，找到之后用它来初始化 Servlet 容器。

Spring实现了以上接口，实现类叫做 SpringServletContainerInitializer， 
它会依次搜寻实现了 WebApplicationInitializer的任何类，并委派这个类实现配置。
之后，Spring 3.2 开始引入一个简易的 WebApplicationInitializer 实现类，
这就是 AbstractAnnotationConfigDispatcherServletInitializer。
所以 SpittrWebAppInitializer 继承 AbstractAnnotationConfigDispatcherServletInitializer之后，
也就是间接实现了 WebApplicationInitializer，在 Servlet 3.0 容器中，
它会被自动搜索到，被用来配置 servlet 上下文。