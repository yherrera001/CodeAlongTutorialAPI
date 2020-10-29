package demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //You can use methods here

public class HelloController {

    //THIS IS USED FOR A GET <---
    @RequestMapping ("/hello")//Takes in a parameter (URL). Whenever there is a HTTP request, add this URL to execute the method and return the value "hi"
    public String sayHi(){
        return "Hi";
    }


}
