package org.example.payload;


public class EmployeeDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private Long employeeType;
    private Long location;
    private Integer salary;
    private String status;

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Long getEmployeeType() {
        return employeeType;
    }

    public Long getLocation() {
        return location;
    }

    public Integer getSalary() {
        return salary;
    }

    public String getStatus() {
        return status;
    }
}
