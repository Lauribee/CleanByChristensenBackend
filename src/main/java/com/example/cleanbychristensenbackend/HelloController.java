package com.example.cleanbychristensenbackend;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin // Allow all domain origins.
@RestController
public class HelloController {

    @GetMapping("/helloworld")
    public String HelloWorld() {
        System.out.println("test awooga");
        return "Hello World!";
    }

}
