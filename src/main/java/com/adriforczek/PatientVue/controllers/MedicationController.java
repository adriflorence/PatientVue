package com.adriforczek.PatientVue.controllers;

import com.adriforczek.PatientVue.entities.Medication;
import com.adriforczek.PatientVue.services.AuthenticationService;
import com.adriforczek.PatientVue.services.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class MedicationController {

    @Autowired
    AuthenticationService authService;

    @Autowired
    MedicationService medicationService;

    @GetMapping("/patient/{userId}/medications")
    @ResponseBody
    public List<Medication> getMedications(@PathVariable String userId){
        return medicationService.getMedications(userId, authService.getToken());
    }
}
