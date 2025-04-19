package org.example.services;


import org.example.model.EmployeeType;
import org.example.payload.EmployeeTypeDTO;

public interface EmployeeTypeService {
    String create(EmployeeTypeDTO request);
    int delete(Long id);
    EmployeeType edit(Long id);
    String update(EmployeeTypeDTO request);
}
