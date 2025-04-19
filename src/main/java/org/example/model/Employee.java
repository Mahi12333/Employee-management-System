package org.example.model;


public class Employee {
    private Long id;
    private String firstname;
    private String lastname;
    private EmployeeType employeeType;
    private Location location;
    private Integer salary;
    private String status;

    public Employee() {

    }

    public Employee(Long id, String firstname, String lastname, EmployeeType employeeType, Location location, Integer salary, String status) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.employeeType = employeeType;
        this.location = location;
        this.salary = salary;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
