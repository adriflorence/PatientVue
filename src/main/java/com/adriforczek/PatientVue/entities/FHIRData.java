package com.adriforczek.PatientVue.entities;

import java.util.List;

public class FHIRData {

    private List<FHIRCondition> conditions;

    public List<FHIRCondition> getConditions() {
        return conditions;
    }

    public void setConditions(List<FHIRCondition> conditions) {
        this.conditions = conditions;
    }
}
