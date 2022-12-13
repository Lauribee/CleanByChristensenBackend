package com.example.cleanbychristensenbackend;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin // Allow all domain origins.
@RestController
public class HelloController {

    @GetMapping("/")
    public String HelloWorld() {
        return "Hello World!";
    }

}
