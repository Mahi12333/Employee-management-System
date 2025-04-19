package org.example.services;

import org.example.model.Location;
import org.example.payload.LocationDTO;

public interface LocationService {
    String create(LocationDTO location);
    int delete(Long id);
    Location edit(Long id);
    String update(LocationDTO request);
}
