package com.adriforczek.PatientVue.controllers;

import com.adriforczek.PatientVue.entities.User;
import com.adriforczek.PatientVue.services.AuthenticationService;
import com.adriforczek.PatientVue.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authService;

    @GetMapping("/basicuserinformation")
    public User getUserInformation() throws JsonProcessingException {
        return userService.getUserInformation(authService.getToken());
    }
}
