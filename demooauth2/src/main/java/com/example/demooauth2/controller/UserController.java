package com.example.demooauth2.controller;

import com.example.demooauth2.model.User;
import com.example.demooauth2.service.UserService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, OAuth2AuthenticationToken authentication) {
        OAuth2User oauthUser = authentication.getPrincipal();
        User user = userService.saveOrUpdateUser(oauthUser);
        for (String key: oauthUser.getAttributes().keySet()){
            System.out.println(key+":   "+oauthUser.getAttribute(key));
        }
        model.addAttribute("user", user);
        return "dashboard"; // Refers to dashboard.html
    }


//    The controller method uses OAuth2AuthenticationToken to retrieve the OAuth2User:
//
//OAuth2User oauthUser = authentication.getPrincipal();

//Here, authentication is the object representing the currently authenticated user via OAuth 2.0, and getPrincipal() fetches the authenticated user's details.

}


//2. OAuth2User
//Definition:
//
//This interface represents an authenticated user's details obtained from the OAuth 2.0 provider.
//It provides a way to access the user's attributes, such as name, email, and other profile details.


//1. OAuth2AuthenticationToken
//Definition:
//
//This class represents the authentication token for an authenticated user with an OAuth 2.0 provider.
//It is used to encapsulate details about the authenticated user and their authorization from the OAuth 2.0 provider.