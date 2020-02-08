package com.adriforczek.PatientVue.controllers;

import com.adriforczek.PatientVue.entities.FHIRData;
import com.adriforczek.PatientVue.entities.User;
import com.adriforczek.PatientVue.services.AuthenticationService;
import com.adriforczek.PatientVue.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    // Given a UserId, get basic patient information for a user
    // from clinical data stored in FHIR database.
    @GetMapping("/patient/{userId}/basic")
    @ResponseBody
    public List<FHIRData> getPatientFHIRData(@PathVariable String userId) {
        return userService.getPatientFHIRData(userId, authService.getToken());
    }
}
