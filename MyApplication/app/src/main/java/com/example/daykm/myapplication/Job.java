package com.example.daykm.myapplication;

public class Job {
    private String position;
    private String location;

    public Job() {
        // Empty constructor for injecting
    }

    public Job(String position, String location) {
        this.position = position;
        this.location = location;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
