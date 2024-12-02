package fr.uge.jee.springmvc.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/Home")
    public String greetings() {
        return "hello";
    }
}
