package com.adriforczek.PatientVue.controllers;

import com.adriforczek.PatientVue.entities.ObservationDAO;
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

    @GetMapping("/observations")
    public ObservationDAO getObservationData(@PathVariable String userId) {
        return observationService.getObservationData(userId, authService.getToken());
    }
}
