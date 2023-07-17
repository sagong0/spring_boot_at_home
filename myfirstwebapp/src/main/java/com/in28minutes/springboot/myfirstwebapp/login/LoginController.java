package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {


//    http://localhost:8080/login?name=chris
    // Model : Controller 에서 Jsp 로 전달 할때 Model 기능으로 가능. (ModelMap)
    @GetMapping("login")
    public String loginViewJsp(@RequestParam String name, ModelMap model){
        model.put("name",name);
        System.out.println("Request Param is :" + name);
        return "login";
    }
}
