package org.example.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    //Handles request at /hello
    //@GetMapping("hello")
    //@ResponseBody
    //public String hello(){
    //    return "Hello, Spring!";
   // }

    //lives /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //lives /hello/hello
    //Handles request of the form /hello?=name=LaunchCode
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value="hello")
    public String helloWithQueryParam(@RequestParam String name, Model model){
        String greeting = "Hello, "+ name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    //Handles request of the form /hello/LaunchCode(exemplu -> aici se poate pune orice nume)
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name, Model model){
        String greeting="Hello, "+name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    //hello/form
    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("C++");
        model.addAttribute("names", names);
        return "hello-list";
    }
}
