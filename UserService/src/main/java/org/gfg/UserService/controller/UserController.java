package org.gfg.UserService.controller;

import org.gfg.UserService.model.User;
import org.gfg.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/get/{uid}")
    public User getUserInformation(@PathVariable("uid") String id){
        int intId = Integer.parseInt(id);
        return userService.getUser(intId);
    }
}
