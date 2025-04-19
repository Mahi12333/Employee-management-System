package org.example.controller;


import org.example.model.Location;
import org.example.payload.LocationDTO;
import org.example.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    LocationService locationService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody LocationDTO request){
       String response = locationService.create(request);
       return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id){
        int response = locationService.delete(id);
        return ResponseEntity.ok("Location deleted successfully!");
    }

    @GetMapping("/edit")
    public ResponseEntity<Location> edit(@RequestParam Long id){
        return ResponseEntity.ok(locationService.edit(id));
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody LocationDTO request){
        String response = locationService.update(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}
