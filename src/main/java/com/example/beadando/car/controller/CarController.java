package com.example.beadando.car.controller;

import com.example.beadando.car.controller.response.CarListResponse;
import com.example.beadando.car.entity.CarEntity;
import com.example.beadando.car.service.imlp.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {


    @Autowired
    private CarServiceImpl service;

    //find by id
    @GetMapping("/api/car/{id}")
    public ResponseEntity findById(@PathVariable Long id) {

        CarEntity entity = service.findById(id);
        if (entity != null) {
            return ResponseEntity.ok(entity);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    //find all
    @GetMapping("/api/car")


    public ResponseEntity<CarListResponse> findAll() {
        CarListResponse response = new CarListResponse();
        response.setCars(service.findAll());
        return ResponseEntity.ok(response);


    }

    //create
    @PostMapping(value = "/api/car", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarEntity> create(@RequestBody CarEntity entity) {
        service.create(entity);
        return ResponseEntity.ok(entity);
    }

    //update @PostMapping
    @PutMapping(value = "/api/car", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CarEntity update(@RequestBody CarEntity entity) {
        return service.update(entity);
    }


    //delete by id @DeleteMapping
    @DeleteMapping("/api/car/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        if (service.deteteById(id)) {
            return ResponseEntity.ok("Sikeres müvelet");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}
