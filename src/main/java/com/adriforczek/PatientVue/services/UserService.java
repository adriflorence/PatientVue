package com.adriforczek.PatientVue.services;

import com.adriforczek.PatientVue.entities.FHIRData;
import com.adriforczek.PatientVue.entities.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    public User getUserInformation(String token) throws JsonProcessingException {
        String url = "https://www.patientview.org/api/auth/{token}/basicuserinformation";

        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Auth-Token", token);

        // build request
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<User> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            request,
            User.class,
            token
        );

        // check response
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful.");
        } else {
            System.out.println("Request Failed");
        }

        User user = response.getBody();
        return user;
    }

    public List<FHIRData> getPatientFHIRData(String userId, String token) {
        String url = "https://www.patientview.org/api/patient/{userId}/basic";

        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Auth-Token", token);

        // build request
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<List<FHIRData>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                // enables capturing and passing a generic Type
                new ParameterizedTypeReference<List<FHIRData>>() {},
                userId
        );

        List<FHIRData> clinicalData =  response.getBody();
        System.out.println(response.getBody().get(0).getFhirConditions());
        return clinicalData;
    }

}
