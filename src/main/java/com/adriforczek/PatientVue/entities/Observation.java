package com.adriforczek.PatientVue.entities;

public class Observation {

    private String id;
    private String applies;
    private String name;
    private String value;
    private Group group;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApplies() {
        return applies;
    }

    public void setApplies(String applies) {
        this.applies = applies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
