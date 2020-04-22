package com.web.controller;

import com.web.dto.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

//https://www.cnblogs.com/fangjian0423/p/springMVC-request-param-analysis.html
//https://www.cnblogs.com/fangjian0423/tag/springmvc/
@Controller
@RequestMapping(value = "/test")
public class TestController {
    /**
     * http://localhost:8080/spring/test/testRb?name=yancy&age=18
     * 结果：报错400
     *
     * 原因：这个方法的参数使用了@RequestBody，被RequestResponseBodyMethodProcessor进行处理,
     * @requestBody注解常用来处理content-type不是默认的application/x-www-form-urlcoded编码的内容，
     * 比如说：application/json或者是application/xml等。一般情况下来说常用其来处理application/json类型.
     * 该请求的头部中没有content-type，默认使用了application/octet-stream，因此触发了
     * HttpMediaTypeNotSupportedException异常
     *
     * 解放方案：我们将传递数据改成json，同时http请求的Content-Type改成application
     *
     * 附：form默认的提交方式content-type是x-www-form-urlencoded，会将传递的参数转换成key-value方式。
     * @param e
     * @return
     */
    @RequestMapping("/testRb")
    @ResponseBody
    public Employee testRb(@RequestBody Employee e) {
        return e;
    }

    /**
     * http://localhost:8080/spring/test/testCustomObj?name=yancy&age=18
     * 结果：正常
     * 原因：这个请求会找到ServletModelAttributeMethodProcessor这个resolver。
     * 默认的resolver中有两个ServletModelAttributeMethodProcessor，只不过实例化的时候属性annotationNotRequired
     * 一个为true，1个为false。这个ServletModelAttributeMethodProcessor处理参数支持@ModelAttribute注解，
     * annotationNotRequired属性为true的话，参数不是简单类型就通过，因此选择了ServletModelAttributeMethodProcessor，
     * 最终通过DataBinder实例化Employee对象，并写入对应的属性。
     *
     * * 该方法同样能接收参数放在body中 ，但需要将请求头设置为：Content-Type: application/x-www-form-urlencoded
     *    此时请求头和body中的参数都能被解析
     * @param e
     * @return
     */
    @RequestMapping("/testCustomObj")
    @ResponseBody
    public Employee testCustomObj(Employee e) {
        return e;
    }

    /**
     *http://localhost:8080/spring/test/testCustomObjWithRp?name=yancy&age=18
     * 结果：报错400
     * 原因：这个请求会找到RequestParamMethodArgumentResolver(使用了@RequestParam注解)。
     * RequestParamMethodArgumentResolver在处理参数的时候使用request.getParameter(参数名)
     * 即request.getParameter("e")得到，很明显我们的参数传的是name=1&age=3。
     * 因此得到null，RequestParamMethodArgumentResolver处理
     * missing value会触发MissingServletRequestParameterException异常
     *
     * 解决方案：去掉@RequestParam注解，让ServletModelAttributeMethodProcessor来处理。
     *

     * @param e
     * @return
     */
    @RequestMapping("/testCustomObjWithRp")
    @ResponseBody
    public Employee testCustomObjWithRp(@RequestParam Employee e) {
        return e;
    }

    /**
     * http://localhost:8080/spring/test/testDate?date=2020-04-21
     * 结果：报错400
     * 原因：这个请求会找到RequestParamMethodArgumentResolver。因为这个方法与第二个方法一样，
     * 有两个RequestParamMethodArgumentResolver，属性useDefaultResolution不同。
     * RequestParamMethodArgumentResolver支持简单类型，ServletModelAttributeMethodProcessor
     * 是支持非简单类型。最终步骤跟第三个方法一样，我们的参数名是date，
     * 于是通过request.getParameter("date")找到date字符串(这里参数名如果不是date，那么最终页面是空白的，
     * 因为没有@RequestParam注解，参数不是必须的，RequestParamMethodArgumentResolver处理null值返回null)。
     * 最后通过DataBinder找到合适的属性编辑器进行类型转换。最终找到java.util.Date对象的构造函数 p
     * ublic Date(String s)，由于我们传递的格式不是标准的UTC时间格式，
     * 因此最终触发了IllegalArgumentException异常。
     *
     *
     * 解决方案：
     * 1. 传递参数的格式修改成标准的UTC时间格式：
     * http://localhost:8080/spring/test/testDate?date=Sat, 17 May 2014 16:30:00 GMT
     * 2.在Controller中加入自定义属性编辑器。
     * @param date
     * @return
     */
    @RequestMapping("/testDate")
    @ResponseBody
    public Date testDate(Date date) {
        return date;
    }

    /**
     * @RequestParam 可以从url中取值，也可以从body中取值，只要名字对应的上，
     * body中取值时，请求头设置为：Content-Type: application/x-www-form-urlencoded
     * @param name
     * @param age
     * @return
     */
    @RequestMapping("/testRequestParam")
    @ResponseBody
    public Employee testRequestParam(@RequestParam String name,@RequestParam int age) {
        return new Employee(name,age);
    }
}
