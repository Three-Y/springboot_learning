package yan.ibbie.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/*
@RestController中包含了@ResponseBody+@Controller
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String helloHandler(){
        return "Hello, Spring Boot 2 !!!";
    }
}
