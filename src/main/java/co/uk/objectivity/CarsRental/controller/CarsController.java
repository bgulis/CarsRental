package co.uk.objectivity.CarsRental.controller;

import co.uk.objectivity.CarsRental.business.CarService;
import co.uk.objectivity.CarsRental.model.Cars;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cars")
public class CarsController {

    private final CarService carsService;

    public CarsController(CarService carsService) {
        this.carsService = carsService;
    }

    @GetMapping
    List<Cars> getAllCars(){
        return carsService.getAllCars();
    }

    @GetMapping("/name/{id}")
    String getCarNameById(@PathVariable Integer id){
        return carsService.getCarNameById(id);
    }
    @GetMapping("/{id}")
    Cars GetCarById(@PathVariable Integer id){
        return carsService.getCarById(id);
    }
}
