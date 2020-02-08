package com.adriforczek.PatientVue.entities;

import java.util.List;

// FHIR = Fast Healthcare Interoperability Resources
public class FHIRData {

    private int id;
    private List<FHIRCondition> fhirConditions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<FHIRCondition> getFhirConditions() {
        return fhirConditions;
    }

    public void setFhirConditions(List<FHIRCondition> fhirConditions) {
        this.fhirConditions = fhirConditions;
    }
}
