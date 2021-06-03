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

    //update @PostMapping
    @PutMapping(value ="/car", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CarEntity update(@RequestBody CarEntity entity) {
        CarEntity updateCar= findById(entity.getId());
        if(updateCar!=null){
            updateCar.setType(entity.getType());
            updateCar.setDoor_number(entity.getDoor_number());
            updateCar.setManufacturer(entity.getManufacturer());
            updateCar.setManufacturer_year(entity.getManufacturer_year());
        }

        return updateCar;
    }



    //delete by id @DeleteMapping
    @DeleteMapping("/car/{id}")
    public String deleteById(@PathVariable Long id){
        for (CarEntity entity : list) {
            if (entity.getId().equals(id)){
                list.remove(entity)
                return "Lófasz";
            }
        }
        return null;
    }
}
