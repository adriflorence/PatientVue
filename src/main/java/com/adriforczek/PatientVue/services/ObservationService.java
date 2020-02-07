package com.adriforczek.PatientVue.services;

import com.adriforczek.PatientVue.entities.Observation;
import com.adriforczek.PatientVue.entities.ObservationDAO;
import com.adriforczek.PatientVue.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ObservationService {

    @Autowired
    RestTemplate restTemplate;

    public ObservationDAO getObservationData(String userId, String token){
        String url = "https://www.patientview.org/api/user/{userId}/observations?" +
             "code=Urea&" +
             "code=creatinine&" +
             "code=Potassium&" +
             "code=Weight&" +
             "code=Tacro&" +
             "&limit=10&offset=0&orderDirection=DESC?";

        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Auth-Token", token);

        // build request
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<ObservationDAO> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                ObservationDAO.class,
                token
        );

        System.out.println(response.getBody());
        ObservationDAO observations = response.getBody();
        return observations;
    }
}
