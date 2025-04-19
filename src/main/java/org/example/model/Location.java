package org.example.model;

public class Location {
    private Long id;
    private String location_name;

    public Location() {
    }

    public Location(Long id, String location_name) {
        this.id = id;
        this.location_name = location_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }
}
