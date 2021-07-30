package zw.co.afrosoft.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeResource {
    @GetMapping("/")
    public String greetings(){
        return "Welcome";
    }
    @GetMapping("/user")
    public String user(){
        return "Welcome User";
    }
    @GetMapping("/admin")
    public String admin(){
        return "Welcome Admin";
    }
}
