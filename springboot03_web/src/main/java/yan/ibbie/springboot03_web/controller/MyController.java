package yan.ibbie.springboot03_web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    /*
    映射与静态资源同名时，访问03.png，是访问静态资源？还是处理器方法？
        访问的是处理器方法
        原理：静态资源的映射路径是/**
             当一个请求进来，会先找更准确的映射，如果没有再从静态资源中寻找
     */
    @RequestMapping("/03.png")
    public String hello(){
        return "Hello";
    }

}
