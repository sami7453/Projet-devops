package com.example.Projet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class ServiceWeb {

    private final List<Car> cars = new ArrayList<>();

    public ServiceWeb() {
        cars.add(new Car("AA11BB", "ferrari", 2000));
        cars.add(new Car("BB22CC", "porsche", 1000));
        cars.add(new Car("CC33DD", "peugeot", 500));
    }

    // Liste complète
    @GetMapping
    public List<Car> allCars() {
        return cars;
    }

    // Recherche par plaque
    @GetMapping("/plate/{plateNumber}")
    public ResponseEntity<Car> getCarByPlate(@PathVariable String plateNumber) {
        return cars.stream()
                .filter(car -> car.getPlateNumber().equalsIgnoreCase(plateNumber))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Recherche par prix
    @GetMapping("/price/{price}")
    public ResponseEntity<List<Car>> getCarsByPrice(@PathVariable int price) {
        List<Car> filtered = cars.stream()
                .filter(car -> car.getPrice() == price)
                .toList();

        if (filtered.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(filtered);
        }
    }
}
