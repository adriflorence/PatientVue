package com.adriforczek.PatientVue.controllers;

import com.adriforczek.PatientVue.entities.User;
import com.adriforczek.PatientVue.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/basicuserinformation")
    public User getUserInformation() {
        return userService.getUserInformation();
    }
}
