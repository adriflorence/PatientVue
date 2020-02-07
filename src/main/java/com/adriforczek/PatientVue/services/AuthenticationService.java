package com.adriforczek.PatientVue.services;

import com.adriforczek.PatientVue.config.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class AuthenticationService implements ApplicationListener<ContextRefreshedEvent> {

    private String token;

    public String getToken() {
        return token;
    }

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Map<String, String> credentials = new HashMap<String, String>();
        credentials.put("username", Credentials.username);
        credentials.put("password", Credentials.password);

        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // build the request
        HttpEntity<Map<String, String>> request = new HttpEntity<>(credentials, headers);

        AuthResponse response = restTemplate.postForObject("https://www.patientview.org/api/auth/login", request, AuthResponse.class, new HashMap<>());
        System.out.println(response.getToken());
        token = response.getToken();
    }
}
