package com.adriforczek.PatientVue.controllers;

import com.adriforczek.PatientVue.entities.User;
import com.adriforczek.PatientVue.services.AuthenticationService;
import com.adriforczek.PatientVue.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    // @RequestParams extract values from the query string
    // @PathVariables extract values from the URI path
    @GetMapping("/patient/{userId}/basic")
    @ResponseBody
    public void getPatientFHIRData(@PathVariable String userId) {
        userService.getPatientFHIRData(userId, authService.getToken());
    }
}
