package co.uk.objectivity.CarsRental.controller;

import co.uk.objectivity.CarsRental.business.CarService;
import co.uk.objectivity.CarsRental.model.Cars;
import co.uk.objectivity.CarsRental.model.OperationStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cars")
public class CarsController {

    private final CarService carsService;

    public CarsController(CarService carsService) {
        this.carsService = carsService;
    }

    @GetMapping
    Object getAllCars(){
        if (carsService.getAllCars().isEmpty()){
            return "No records";
        }else{
            return carsService.getAllCars();
        }

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
    String updateCarById(@RequestBody Cars car, @PathVariable("id") Integer id){

            return carsService.updateCarById(car, id);

    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    String addNewCar(@RequestBody Cars car){
//        if(carsService.addCar(car)){
//            return OperationStatus.SUCCESS;
//        }else{
//            return OperationStatus.FAILURE;
//        }
        return carsService.addCar(car);
    }


}
