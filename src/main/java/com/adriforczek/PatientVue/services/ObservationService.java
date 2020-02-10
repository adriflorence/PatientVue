package com.adriforczek.PatientVue.services;

import com.adriforczek.PatientVue.entities.ObservationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class ObservationService {

    @Autowired
    RestTemplate restTemplate;

    public ObservationResponse getObservationData(String userId, String token){
        String url = "https://www.patientview.org/api/user/{userId}/observations?" +
             "code=Urea&" +
             "code=creatinine&" +
             "code=potassium&" +
             "code=Weight&" +
             "code=tacrolimus&" +
             "&limit=10&offset=0&orderDirection=DESC?";

        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Auth-Token", token);

        // build request
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<ObservationResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                ObservationResponse.class,
                userId
        );
        
        System.out.println(response.getBody());
        ObservationResponse res = response.getBody();
        return res;
    }
}
