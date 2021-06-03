package com.example.demo.car;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CarController {

    //find by id
    @GetMapping("/car/{id}")
    public CarEntity findById(@PathVariable Long Id){
        CarEntity entity=new CarEntity();
        entity.setId(Id);
        entity.setType("Pickup");
        entity.setDoor_number(5);
        entity.setManufacturer("Ford");
        entity.setManufacturer_year(2019);


        return entity;
    }

    //find all
    @GetMapping("/car")
    public CarListResponse findAll(){
        CarListResponse response=new CarListResponse();
        List<CarEntity> list=new ArrayList<>();
        for (int i = 0; i<10; i++){
            CarEntity entity=new CarEntity();
            entity.setId(Long.parseLong(i+""));
            entity.setType("Pickup"+1);
            entity.setDoor_number(5);
            entity.setManufacturer("Ford");
            entity.setManufacturer_year(2009+1);
            list.add(entity);
            
        }
        response.setCars(list);
        return response;
            

    }

    //create

    //update

    //delete by id
}
