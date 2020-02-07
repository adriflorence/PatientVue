package com.adriforczek.PatientVue.entities;

import java.util.List;

public class ObservationDAO {

    private List<Observation> observations;

    public List<Observation> getObservations() {
        return observations;
    }

    public void setObservations(List<Observation> observations) {
        this.observations = observations;
    }
}
