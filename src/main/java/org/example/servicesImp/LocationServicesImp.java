package org.example.servicesImp;

import org.example.model.Location;
import org.example.payload.LocationDTO;
import org.example.services.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;



@Service
public class LocationServicesImp implements LocationService {
    private static  final Logger logger = LoggerFactory.getLogger(LocationServicesImp.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String create(LocationDTO request) {
        logger.info("location--{}", request.getLocationName());
        String sql = "INSERT INTO location (location_name) " + "VALUES (?)";
        int rows = jdbcTemplate.update(sql, request.getLocationName());
        return rows > 0 ? "Location Created Successfully" : "Location Created Failed";
    }

    @Override
    public int delete(Long id) {
        logger.info("delete id--{}", id);
        String sql = "DELETE FROM location WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Location edit(Long id) {
        String sql = "SELECT * FROM location WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Location.class), id);
    }

    @Override
    public String update(LocationDTO request) {
        String sql = "UPDATE location SET location_name = ? WHERE id = ?";
        int rows = jdbcTemplate.update(sql, request.getLocationName(), request.getId());
        return rows > 0 ? "Location Update Successfully" : "Location Update Failed";
    }
}
