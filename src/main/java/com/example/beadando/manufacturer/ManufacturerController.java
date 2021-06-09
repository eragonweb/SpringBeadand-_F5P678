package com.example.beadando.manufacturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ManufacturerController {


    @Autowired
    private ManufacturerService service;

    //find by id
    @GetMapping("/manufacturer/{id}")
    public ResponseEntity findById(@PathVariable Long id) {

        ManufacturerEntity entity = service.findById(id);
        if (entity != null) {
            return ResponseEntity.ok(entity);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    //find all
    @GetMapping("/manufacturer")
    public ResponseEntity<ManufacturerListResponse> findAll() {
        ManufacturerListResponse response = new ManufacturerListResponse();
        response.setManufacturers(service.findAll());
        return ResponseEntity.ok(response);


    }

    //create
    @PostMapping(value = "/manufacturer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ManufacturerEntity> create(@RequestBody ManufacturerEntity entity) {
       service.create(entity);
        return ResponseEntity.ok(entity);
    }

    //update @PostMapping
    @PutMapping(value = "/manufacturer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ManufacturerEntity update(@RequestBody ManufacturerEntity entity) {
          return service.update(entity);
    }


    //delete by id @DeleteMapping
    @DeleteMapping("/manufacturer/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        if(service.deteteById(id)){
            return ResponseEntity.ok("Sikeres müvelet");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}
