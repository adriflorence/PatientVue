package com.adriforczek.PatientVue.controllers;

import com.adriforczek.PatientVue.entities.Observation;
import com.adriforczek.PatientVue.services.ObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ObservationController {

    @Autowired
    ObservationService observationService;

    @GetMapping("/observations")
    public List<Observation> getAllObservations() {
        return observationService.getAllObservations();
    }

    @GetMapping("/observations/{code}")
    public Observation getSingleObservation(@RequestParam String code){
        return null;
    }
}
