package com.adriforczek.PatientVue.services;

import com.adriforczek.PatientVue.resources.ObservationResource;
import com.adriforczek.PatientVue.entities.ObservationResponse;
import org.springframework.stereotype.Component;

@Component
public class ObservationTransformationService {

    public ObservationResource createResource(ObservationResponse response) {
        System.out.println(response);
        ObservationResource resource = new ObservationResource(response.getTotalElements());
        return resource;
    }

}
