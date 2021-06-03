package com.example.beadando.car;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CarController {

    //TODO nem best practice
    private List<CarEntity> list =new ArrayList<>();
    public CarController() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CarEntity entity = new CarEntity();
            entity.setId(Long.parseLong(i + ""));
            entity.setType("Pickup" + i);
            entity.setDoor_number(5);
            entity.setManufacturer("Ford");
            entity.setManufacturer_year(2009 + i);
            list.add(entity);
        }
    }

    //find by id
    @GetMapping("/car/{id}")
    public CarEntity findById(@PathVariable Long id){
         for (CarEntity entity : list) {
            if (entity.getId().equals(id)){
                return entity;
            }
        }
        return null;
    }

    //find all
    @GetMapping("/car")
    public CarListResponse findAll(){
        CarListResponse response=new CarListResponse();
        response.setCars(list);
        return response;
            

    }

    //create
    @PostMapping(value ="/car", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CarEntity create(@RequestBody CarEntity entity){
        list.add(entity);
        return entity;
    }

    //update

    //delete by id
}
