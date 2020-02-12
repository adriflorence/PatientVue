package com.adriforczek.PatientVue.services;

import com.adriforczek.PatientVue.entities.Medication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class MedicationService {

    @Autowired
    RestTemplate restTemplate;

    public List<Medication> getMedications(String userId, String token){
        String url = "https://www.patientview.org/api/user/46134987/medication";

        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Auth-Token", token);

        // build request
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<List<Medication>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                new ParameterizedTypeReference<List<Medication>>() {
                },
                userId
        );

        List<Medication> medications = response.getBody();
        return medications;
    }

}
