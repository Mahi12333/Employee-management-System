package org.example.servicesImp;

import org.example.excption.APIException;
import org.example.model.Employee;
import org.example.model.EmployeeType;
import org.example.model.Location;
import org.example.model.Product;
import org.example.payload.EmployeeDTO;
import org.example.payload.ProductDTO;
import org.example.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImp.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String createEmployee(EmployeeDTO request) {
        logger.info("Employee -- {}", request);
        String sql = "INSERT INTO employee (name, firstname, lastname, salary, status, employee_type_id, location_id) " + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        int rows = jdbcTemplate.update(sql,
                request.getFirstname(),
                request.getFirstname(),
                request.getLastname(),
                request.getSalary(),
                request.getStatus(),
                request.getEmployeeType(),
                request.getLocation()
        );
        return rows > 0 ? "Employee Created Successfully" : "Employee Creation Failed";
    }

    @Override
    public String updateEmployee(Long id, EmployeeDTO request) {

        String sql = "UPDATE employee SET firstname = ?, lastname = ?, salary = ?, status = ?, employee_type_id = ?, location_id = ? WHERE id = ?";
        int updatedSuccess = jdbcTemplate.update(sql,
                request.getFirstname(),
                request.getLastname(),
                request.getSalary(),
                request.getStatus(),
                request.getEmployeeType(),
                request.getLocation(),
                id
        );
        if(updatedSuccess == 0){
            throw new APIException("This is not exists!");
        }
        return "Employee Updated Successfully";
    }

    @Override
    public int deleteEmployee(Long id) {
        return jdbcTemplate.update("DELETE FROM employee WHERE id = ?", id);
    }

    @Override
    public Product getEmployeeById(Long id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Product.class), id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT " +
                "e.id, e.firstname, e.lastname, e.salary, e.status, " +
                "et.id AS employeeTypeId, et.type_name AS employeeTypeName, " +
                "l.id AS locationId, l.location_name AS locationName " +
                "FROM employee e " +
                "JOIN employee_type et ON e.employee_type_id = et.id " +
                "JOIN location l ON e.location_id = l.id";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Employee employee = new Employee();
            employee.setId(rs.getLong("id"));
            employee.setFirstname(rs.getString("firstname"));
            employee.setLastname(rs.getString("lastname"));
            employee.setSalary(rs.getInt("salary"));
            employee.setStatus(rs.getString("status"));

            // Map EmployeeType
            EmployeeType type = new EmployeeType();
            type.setId(rs.getLong("employeeTypeId"));
            type.setType_name(rs.getString("employeeTypeName"));
            employee.setEmployeeType(type);

            // Map Location
            Location location = new Location();
            location.setId(rs.getLong("locationId"));
            location.setLocation_name(rs.getString("locationName"));
            employee.setLocation(location);

            return employee;
        });
    }
}
