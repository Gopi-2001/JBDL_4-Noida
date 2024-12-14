package org.gfg.JBDL4_OAuth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @GetMapping("/home/controller")
    public String home(){
        return "Inside Home page";
    }


    @GetMapping("/get/secret")
    public String secretResource(){
        return "Secret URL";
    }

    @GetMapping("/success")
    public String success(){
        return "Success Page";
    }
}
