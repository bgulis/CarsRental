package co.uk.objectivity.CarsRental.controller;

import co.uk.objectivity.CarsRental.business.CarService;
import co.uk.objectivity.CarsRental.model.Cars;
import co.uk.objectivity.CarsRental.model.OperationStatus;
import co.uk.objectivity.CarsRental.model.Status;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
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

    @DeleteMapping("/{id}")
    OperationStatus deleteCarById(@PathVariable Integer id){
        if(carsService.deleteCarById(id)){
            return OperationStatus.SUCCESS;
        }else{
            return OperationStatus.FAILURE;
        }
    }

    @PutMapping("/{id}")
    OperationStatus updateCarById(@RequestBody Cars car, @PathVariable("id") Integer id){
        if(carsService.updateCarById(id)){
            return OperationStatus.SUCCESS;
        }else{
            return OperationStatus.FAILURE;
        }
    }

    @PostMapping
    Cars addNewCar(@RequestParam String carModel, String status, BigDecimal price, String features){
        Status newStatus = Status.IN_USE;
        List<String> newFeatures = new ArrayList<>(Arrays.asList(features.split(",")));

        if (status.compareTo("FREE_TO_USE") == 0){
                newStatus = Status.FREE_TO_USE;
        }
        return new Cars(4, carModel, newStatus, price, newFeatures);
//        return carsService.addCar(newCar);
    }


}
