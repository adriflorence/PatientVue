package com.adriforczek.PatientVue.resources;

import com.adriforczek.PatientVue.entities.Observation;

import java.util.List;

public class ObservationResource {

    private String observationName;
    private int totalElements;
    private List<Observation> observations;

    public ObservationResource(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public String getObservationName() {
        return observationName;
    }

    public void setObservationName(String observationName) {
        this.observationName = observationName;
    }

    public List<Observation> getObservations() {
        return observations;
    }

    public void setObservations(List<Observation> observations) {
        this.observations = observations;
    }
}
