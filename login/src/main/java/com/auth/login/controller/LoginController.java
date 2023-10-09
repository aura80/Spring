package com.auth.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class LoginController {

    @GetMapping("/")
    public String getMessage(Principal principal) {
        return "Hello " + principal.getName() + " , I'm a message!";
    }

    @GetMapping("/secured")
    public String secured(Principal principal) {
        return "Hello " + principal.getName() + " , I'm viewing the secured page now!";
    }
}
