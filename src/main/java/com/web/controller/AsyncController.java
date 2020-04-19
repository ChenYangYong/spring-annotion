package com.web.controller;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Callable;

@Controller
public class AsyncController {

    @ResponseBody
    @RequestMapping("/sync")
    public Callable<String> sync() throws Exception{
        System.out.println("主线程"+Thread.currentThread().getName()+"开始="+DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss SSS"));
        Callable<String> callable = new Callable<String>() {
            public String call() throws Exception {
                System.out.println("副线程"+Thread.currentThread().getName()+"开始="+DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss SSS"));
                Thread.sleep(10*1000);
                System.out.println("副线程"+Thread.currentThread().getName()+"结束="+DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss SSS"));
                return "Callable<String> sync()";
            }
        };
        System.out.println("主线程"+Thread.currentThread().getName()+"结束"+DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss SSS"));
        return callable;
    }
    @ResponseBody
    @RequestMapping("/sync1")
    public DeferredResult<String> sync1() throws Exception{
        System.out.println("主线程"+Thread.currentThread().getName()+"开始="+DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss SSS"));
        final DeferredResult<String> result = new DeferredResult<String>(5000L,"处理超时");
        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("副线程"+Thread.currentThread().getName()+"开始="+DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss SSS"));
                    Thread.sleep(3*1000);
                    result.setResult(UUID.randomUUID().toString());
                    System.out.println("副线程"+Thread.currentThread().getName()+"结束="+DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss SSS"));
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        }.start();
        System.out.println("主线程"+Thread.currentThread().getName()+"结束"+DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss SSS"));
        return result;
    }
}
