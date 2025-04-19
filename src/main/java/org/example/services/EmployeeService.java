package org.example.services;

import org.example.model.Employee;
import org.example.model.Product;
import org.example.payload.EmployeeDTO;
import org.example.payload.ProductDTO;

import java.util.List;

public interface EmployeeService {
    String  createEmployee(EmployeeDTO request);
    String updateEmployee(Long id, EmployeeDTO request);
    int deleteEmployee(Long id);
    Product getEmployeeById(Long id);
    List<Employee> getAllEmployees();
}
