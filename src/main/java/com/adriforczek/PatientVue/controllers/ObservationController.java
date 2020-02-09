package com.adriforczek.PatientVue.controllers;

import com.adriforczek.PatientVue.entities.ObservationResponse;
import com.adriforczek.PatientVue.services.AuthenticationService;
import com.adriforczek.PatientVue.services.ObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class ObservationController {

    @Autowired
    AuthenticationService authService;

    @Autowired
    ObservationService observationService;


    // @RequestParams extract values from the query string
    // @PathVariables extract values from the URI path
    @GetMapping("/patient/{userId}/observations")
    public ObservationResponse getObservationData(@PathVariable String userId) {
        return observationService.getObservationData(userId, authService.getToken());
    }
}
