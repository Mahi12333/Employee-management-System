package org.example.model;

public class EmployeeType {
    private Long id;
    private String type_name;

    public EmployeeType() {

    }

    public EmployeeType(Long id, String type_name) {
        this.id = id;
        this.type_name = type_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }
}
