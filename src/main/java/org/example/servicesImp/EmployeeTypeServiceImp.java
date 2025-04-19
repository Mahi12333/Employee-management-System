package org.example.servicesImp;


import org.example.excption.APIException;
import org.example.model.EmployeeType;
import org.example.payload.EmployeeTypeDTO;
import org.example.services.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeTypeServiceImp implements EmployeeTypeService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String create(EmployeeTypeDTO request) {
        String sql = "INSERT INTO employee_type (type_name) " + "VALUES(?)";
        int rows = jdbcTemplate.update(sql, request.getTypename());
        return rows > 0 ? "Employee Created Successfully" : "Employee Created Failed";
    }

    @Override
    public int delete(Long id) {
        String sql = "DELETE FROM location WHERE id = ?";
        return jdbcTemplate.update(sql, id);

    }

    @Override
    public EmployeeType edit(Long id) {
        String sql = "SELECT * FROM employee_type WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(EmployeeType.class), id);
    }

    @Override
    public String update(EmployeeTypeDTO request) {
        String sql = "UPDATE employee_type SET type_name = ? WHERE id = ?";
        int rows = jdbcTemplate.update(sql, request.getTypename(), request.getId());
        return rows > 0 ? "EmployeeType Update Successfully" : "EmployeeType Update Failed";
    }
}
