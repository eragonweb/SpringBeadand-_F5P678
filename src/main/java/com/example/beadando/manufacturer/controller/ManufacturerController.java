package com.example.beadando.manufacturer.controller;

import com.example.beadando.manufacturer.controller.response.ManufacturerListResponse;
import com.example.beadando.manufacturer.entity.ManufacturerEntity;
import com.example.beadando.manufacturer.service.impl.ManufacturerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ManufacturerController {


    @Autowired
    private ManufacturerServiceImpl service;

    //find by id
    @GetMapping("/api/manufacturer/{id}")
    public ResponseEntity findById(@PathVariable Long id) {

        ManufacturerEntity entity = service.findById(id);
        if (entity != null) {
            return ResponseEntity.ok(entity);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    //find all
    @GetMapping("/api/manufacturer")
    public ResponseEntity<ManufacturerListResponse> findAll() {
        ManufacturerListResponse response = new ManufacturerListResponse();
        response.setManufacturers(service.findAll());
        return ResponseEntity.ok(response);


    }

    //create
    @PostMapping(value = "/api/manufacturer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ManufacturerEntity> create(@RequestBody ManufacturerEntity entity) {
        service.create(entity);
        return ResponseEntity.ok(entity);
    }

    //update @PostMapping
    @PutMapping(value = "/api/manufacturer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ManufacturerEntity> update(@RequestBody ManufacturerEntity entity) {
        return ResponseEntity.ok(service.update(entity));
    }


    //delete by id @DeleteMapping
    @DeleteMapping("/api/manufacturer/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        if (service.deteteById(id)) {
            return ResponseEntity.ok("Sikeres müvelet");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}
