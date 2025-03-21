package com.example.Projet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ServiceWeb {

    ArrayList<Car>cars = new ArrayList<Car>();

    public ServiceWeb() {
        Car car = new Car("AA11BB", "ferrari", 2000);
        cars.add(car);
        car = new Car("BB22CC", "porsche", 1000);
        cars.add(car);
        car = new Car("CC33DD", "peugeot", 500);
        cars.add(car);
    }


    @GetMapping("/cars/{plateNumber}")
    public Car disBonjour(@PathVariable("plateNumber") String plaque){
        int i=0;
        while(i<cars.size() && cars.get(i).getPlateNumber().equals(plaque)==false){
            i++;
        }
        if(i < cars.size()){
            return cars.get(i);
        } else {
            return null;
        }
    }
}
