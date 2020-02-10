package com.adriforczek.PatientVue.controllers;

import com.adriforczek.PatientVue.resources.ObservationResource;
import com.adriforczek.PatientVue.entities.ObservationResponse;
import com.adriforczek.PatientVue.services.AuthenticationService;
import com.adriforczek.PatientVue.services.ObservationService;
import com.adriforczek.PatientVue.services.ObservationTransformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class ObservationController {

    @Autowired
    AuthenticationService authService;

    @Autowired
    ObservationService observationService;

    @Autowired
    ObservationTransformationService observationTransformationService;


    // @RequestParams extract values from the query string
    // @PathVariables extract values from the URI path
    @GetMapping("/patient/{userId}/observations")
    public ObservationResource getObservationData(@PathVariable String userId) {
        ObservationResponse response =  observationService.getObservationData(userId, authService.getToken());
        return observationTransformationService.createResource(response);
    }
}
