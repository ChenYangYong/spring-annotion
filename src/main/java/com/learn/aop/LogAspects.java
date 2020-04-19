package com.learn.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class LogAspects {

    @Pointcut("execution(* *.div(..))")
    public void pointCut(){

    }
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"日志开始，参数列表：{"+Arrays.asList(joinPoint.getArgs()) +"}");
    }
    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"日志结束，参数列表：{}");
    }
    //joinPoint一定要出现在参数表第一位
    @AfterReturning(value = "pointCut()" ,returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        System.out.println("日志返回:"+result);
    }
    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void logException(JoinPoint joinPoint,Exception e){
        System.out.println("方法"+joinPoint.getSignature().getName()+"，参数列表：{"+Arrays.asList(joinPoint.getArgs()) +"} 运行异常，"+e);
    }
}
