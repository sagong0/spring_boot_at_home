package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
    /* say-hello  => Hello! what are u learning today?
    **/

//    /say-hello
    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello(){
        return "Hello! what are u learning today?";
    }


    // JSP (JAVA Server Page)
    // say-hello-jsp => sayHello.jsp
    // resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp(){
        return "sayHello";
    }

    /**
     * say-hello-jsp => SayHelloController > sayHelloJSP mehtod() -> sayHello
     * propterties의 prefix,suffix 설정에의하여
     * ->>>  /WEB-INF/jsp/sayHello.jsp
     * */
}
