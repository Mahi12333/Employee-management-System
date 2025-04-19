package org.example.controller;


import org.example.model.EmployeeType;
import org.example.payload.EmployeeTypeDTO;
import org.example.services.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee_type")
public class EmployeeTypeController {
    @Autowired
    private EmployeeTypeService employeeTypeService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EmployeeTypeDTO request){
        String response = employeeTypeService.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id){
        int response = employeeTypeService.delete(id);
        return ResponseEntity.ok("Location deleted successfully!");
    }

    @GetMapping("/edit")
    public ResponseEntity<EmployeeType> edit(@RequestParam Long id){
        return ResponseEntity.ok(employeeTypeService.edit(id));
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody EmployeeTypeDTO request){
        String response = employeeTypeService.update(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
