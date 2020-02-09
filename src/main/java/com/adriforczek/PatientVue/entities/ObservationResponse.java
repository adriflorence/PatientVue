package com.adriforczek.PatientVue.entities;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObservationResponse {

    private int totalElements;
    private Map<String, Map<String, List<Observation>>> data = new HashMap<>();

    public Map<String, Map<String, List<Observation>>> getData() {
        return data;
    }

    public void setData(Map<String, Map<String, List<Observation>>> data) {
        this.data = data;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }
}
